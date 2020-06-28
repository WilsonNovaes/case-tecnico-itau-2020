package beans;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.DefaultListModel;

import servicos.WSCorreios;

public class Checkout {
	
	private float valorTotalProdutos;
	private float valorTotalFrete;
	private float valorTotalCarrinho;
	private ArrayList<String> listaIsencao; 
	private String erroMensagem = "";
	
	
	
	public Checkout(Carrinho carrinho, Dados dados) {
		
		carregaListaIsencao();
		
		DefaultListModel<ProdutoSelecionado> listaProdutos = carrinho.getLsProdutosSelecionados();
		float totalProdutos = 0;
		float totalFrete = 0;
		float totalCarrinho = 0;
		
		for (int i = 0 ; i < listaProdutos.getSize(); i++) {
			ProdutoSelecionado prodVez = listaProdutos.get(i);
			checkCupomDesconto(prodVez, dados);
			checkIsencao(prodVez);
			checkFrete(prodVez, dados);
			
			totalProdutos+=prodVez.getValorProduto();
			totalFrete+=prodVez.getValorFrete();
			
		}
		totalCarrinho = totalProdutos + totalFrete;
		
		System.out.println("totalProdutos: "+totalProdutos);
		System.out.println("totalFrete: "+ totalFrete);
		System.out.println("totalCarrinho :"+totalCarrinho);
		System.out.println();
		System.out.println("Msg Retorno: "+erroMensagem);
		
		valorTotalProdutos = totalProdutos;
		valorTotalFrete = totalFrete;
		valorTotalCarrinho = totalCarrinho;
		
		
	}
	
	
	private void checkFrete(ProdutoSelecionado produtoSelecionado, Dados dados) {
		if (!produtoSelecionado.isDigital()) {
			WSCorreios wscorreios = new WSCorreios();
			wscorreios.setParametro("sCepOrigem", dados.getCepOrigem());
			wscorreios.setParametro("sCepDestino", dados.getCepDestino());
			wscorreios.setParametro("nCdServico",String.valueOf(dados.getServicoCorreios().getCodigoServico()));
			wscorreios.setParametro("nVlPeso", String.valueOf(produtoSelecionado.getValorPeso()));
			wscorreios.setParametro("nVlComprimento", String.valueOf(produtoSelecionado.getValorComprimento()));
			wscorreios.setParametro("nVlAltura", String.valueOf(produtoSelecionado.getValorAltura()));
			wscorreios.setParametro("nVlLargura", String.valueOf(produtoSelecionado.getValorLargura()));
			wscorreios.setParametro("nVlDiametro", String.valueOf(produtoSelecionado.getValorDiametro()));
			wscorreios.setParametro("nCdFormato", String.valueOf(produtoSelecionado.getCodigoFormato()));
			wscorreios.setParametro("nVlValorDeclarado",String.valueOf(produtoSelecionado.getValorProduto()));
			
			
			WSCorreiosBeanResponse retornoWS = new WSCorreiosBeanResponse(wscorreios.solicitaGET());
			float valorFrete = Float.parseFloat(retornoWS.getValor().replace(",", "."));
			
			produtoSelecionado.setValorFrete(valorFrete);
			
			System.out.println("Verificando Produto: "+produtoSelecionado.getNomeProduto());
			System.out.println("MsgErro: "+retornoWS.getMsgErro());
			
			if (retornoWS.getMsgErro() != null && retornoWS.getMsgErro().trim()!="") {
				erroMensagem+="["+produtoSelecionado.getNomeProduto()+"] "+retornoWS.getMsgErro()+"\r\n";
			}
		}
	}
	
	
	private void checkIsencao(ProdutoSelecionado produtoSelecionado) {
		if (listaIsencao.contains(produtoSelecionado.getTipoProduto().toLowerCase()) ) {
			produtoSelecionado.setValorProduto((float)( produtoSelecionado.getValorProduto() * 0.9));
		}
	}
	
	
	private void checkCupomDesconto(ProdutoSelecionado produtoSelecionado, Dados dados) {
		if (produtoSelecionado.isPromocao()) {
			try (InputStream input = new FileInputStream("aux_files/cupom.properties")) {
	            Properties prop = new Properties();
	            prop.load(input);
	            
	            if (prop.getProperty(dados.getCupomDesconto())!=null && prop.getProperty(dados.getCupomDesconto())!="" && !produtoSelecionado.isDescontoAplicado()) {
	            	float porcentagemCupom = Float.parseFloat(prop.getProperty(dados.getCupomDesconto()));
	 	            float valorDescontoAplicado = (float) (produtoSelecionado.getValorProduto() * (1 - (porcentagemCupom/100)));
	 	            
	 	            produtoSelecionado.setDescontoAplicado(true);
	 	            // TESTES
	 	            System.out.println("Valor Produto: "+produtoSelecionado.getValorProduto());
	 	            System.out.println("Percent Desconto Obtido: "+porcentagemCupom);
	 	            System.out.println("Valor com desconto: "+valorDescontoAplicado);
	 	            
	 	            produtoSelecionado.setValorProduto(valorDescontoAplicado);
	            }
	            
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } catch (Exception es) {
	        	es.printStackTrace();
	        }
			
		}
	}
	
	
	
	
	private void carregaListaIsencao() {
		listaIsencao = new ArrayList<>();
		listaIsencao.add("revista");
		listaIsencao.add("jornal");
		listaIsencao.add("livro");
		listaIsencao.add("ereader");
	}
	
	public float getValorTotalFrete() {
		return valorTotalFrete;
	}

	public void setValorTotalFrete(float valorTotalFrete) {
		this.valorTotalFrete = valorTotalFrete;
	}

	public float getValorTotalProdutos() {
		return valorTotalProdutos;
	}

	public void setValorTotalProdutos(float valorTotalProdutos) {
		this.valorTotalProdutos = valorTotalProdutos;
	}

	public float getValorTotalCarrinho() {
		return valorTotalCarrinho;
	}

	public void setValorTotalCarrinho(float valorTotalCarrinho) {
		this.valorTotalCarrinho = valorTotalCarrinho;
	}


	public String getErroMensagem() {
		return erroMensagem;
	}


	public void setErroMensagem(String erroMensagem) {
		this.erroMensagem = erroMensagem;
	}
	
	

}
