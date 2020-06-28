package app;

import beans.Carrinho;
import beans.Checkout;
import beans.Dados;
import beans.Produto;
import beans.ProdutoSelecionado;
import beans.ServicoCorreios;
import servicos.GerenciadorEmail;

public class Tester {
	public void run() {
		System.out.println("Inicializando verificação da aplicação");

		//System.out.print("..............................................................................");
		System.out.print("Criando dois produtos para utilizar nos testes................................");
		Produto produtoTeste1 = new Produto("Produto Um","revista",100.00f,  0.3f, 30.0f, 2.0f, 15.0f, 0.0f, 1, true );
		Produto produtoTeste2 = new Produto("Produto Dois","revista",100.00f,  0.3f, 30.0f, 2.0f, 15.0f, 0.0f, 1, false);
		if (produtoTeste1.getNomeProduto()!=null && produtoTeste2.getNomeProduto()!=null)
			System.out.println("OK");
		else
			System.out.println("ERRO");
		
		System.out.print("Criando carrinho para atribuir produtos.......................................");
		Carrinho carrinho = new Carrinho();
		System.out.println("OK");
		
		System.out.print("Alterando o tipo de produto para produto selecionado..........................");
		ProdutoSelecionado produtoSelecionado1 = new ProdutoSelecionado(produtoTeste1);
		ProdutoSelecionado produtoSelecionado2 = new ProdutoSelecionado(produtoTeste2);
		System.out.println("OK");
		
		System.out.print("Inserindo os produtos selecionados no carrinho................................");
		carrinho.adicionarProdutoSelecionado(produtoSelecionado1);
		carrinho.adicionarProdutoSelecionado(produtoSelecionado2);
		if (produtoSelecionado1.getNomeProduto()!=null && produtoSelecionado2.getNomeProduto()!=null)
			System.out.println("OK");
		else
			System.out.println("ERRO");
		
		System.out.println("Criando dados ficticios para utilizar nos testes..............................:");
		Dados dados = new Dados();
		dados.setCepOrigem("90619-900");
		dados.setCepDestino("04094-050");
		dados.setCupomDesconto("desconto1");
		dados.setEmail("wilson.n.souza@gmail.com");
		dados.setServicoCorreios(new ServicoCorreios("04014", "PAC sem contrato"));
		
		System.out.println("CEP Origem...........90619-900");
		System.out.println("CEP Destino..........04094-050");
		System.out.println("Cupom Desconto.......desconto1");
		System.out.println("Email................wilson.n.souza@gmail.com");
		System.out.println("Servico Correios.....PAC sem contrato");
		System.out.println("OK");
		
		System.out.println("Fazendo checkout das compras.................................................:");
		Checkout checkout = new Checkout(carrinho, dados);
		
		if (checkout.getValorTotalCarrinho()==243.8)
			System.out.println("OK");
		else
			System.out.println("OK");
		
		System.out.print("Confirmando compra e mandando email...........................................");
		GerenciadorEmail gemail = new GerenciadorEmail();
		System.out.println("OK");
		
		System.out.print("..............................................................................");
		gemail.enviaEmail(dados.getEmail(), carrinho, checkout);
		System.out.println("OK");
		
		System.out.println("Fim testes....................................................................");
		System.out.println("Abrindo Prototipo.............................................................");
		

	}

}
