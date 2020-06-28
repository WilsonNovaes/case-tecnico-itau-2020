package beans;

import javax.swing.DefaultListModel;

public class Produto {

	private String nomeProduto;
	private String tipoProduto;
	private float valorProduto;
	
	private float valorPeso;
	private float valorComprimento;
	private float valorAltura;
	private float valorLargura;
	private float valorDiametro;
	private int codigoFormato;
	
	private boolean isPromocao;
	
	
	public Produto (
			String _nomeProduto, 
			String _tipoProduto, 
			float _valorProduto,
			float _valorPeso,
			float _valorComprimento,
			float _valorAltura,
			float _valorLargura,
			float _valorDiametro,
			int _codigoFormato,
			boolean _isPromocao
			) {
		this.nomeProduto = _nomeProduto;
		this.tipoProduto = _tipoProduto;
		this.valorProduto = _valorProduto;
		this.valorPeso = _valorPeso;
		this.valorComprimento = _valorComprimento;
		this.valorAltura = _valorAltura;
		this.valorLargura = _valorLargura;
		this.valorDiametro = _valorDiametro;
		this.codigoFormato = _codigoFormato;
		this.isPromocao = _isPromocao;
	}
	
	
	public static DefaultListModel<Produto> carregaProdutosExemplosTela() {

		Produto produtoTeste1 = new Produto("Produto Um", "filme", 100.00f, 0.3f, 30.0f, 2.0f, 15.0f, 0.0f, 1, true);
		Produto produtoTeste2 = new Produto("Produto Dois", "revista", 25.00f, 0.5f, 32.0f, 3.0f, 25.0f, 0.0f, 1, false);
		Produto produtoTeste3 = new Produto("Produto Tres", "livro", 32.00f, 0.4f, 35.0f, 5.0f, 15.0f, 0.0f, 1, true);
		Produto produtoTeste4 = new Produto("Produto Quatro", "jornal", 22.00f, 0.6f, 40.0f, 2.0f, 44.0f, 0.0f, 1, false);
		Produto produtoTeste5 = new Produto("Produto Cinco", "serie", 215.00f, 1.3f, 120.0f, 6.0f, 53.0f, 0.0f, 1, true);
		Produto produtoTeste6 = new Produto("Produto Seis", "revista", 20.00f, 0.3f, 33.0f, 1.0f, 15.0f, 0.3f, 1, false);
		DefaultListModel<Produto> lsmProdutos;
		lsmProdutos = new DefaultListModel<>();

		lsmProdutos.addElement(produtoTeste1);
		lsmProdutos.addElement(produtoTeste2);
		lsmProdutos.addElement(produtoTeste3);
		lsmProdutos.addElement(produtoTeste4);
		lsmProdutos.addElement(produtoTeste5);
		lsmProdutos.addElement(produtoTeste6);
		return lsmProdutos;
	}
	

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public float getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(float valorProduto) {
		this.valorProduto = valorProduto;
	}
	
	
	public float getValorPeso() {
		return valorPeso;
	}


	public void setValorPeso(float valorPeso) {
		this.valorPeso = valorPeso;
	}


	public float getValorComprimento() {
		return valorComprimento;
	}


	public void setValorComprimento(float valorComprimento) {
		this.valorComprimento = valorComprimento;
	}


	public float getValorAltura() {
		return valorAltura;
	}


	public void setValorAltura(float valorAltura) {
		this.valorAltura = valorAltura;
	}


	public float getValorLargura() {
		return valorLargura;
	}


	public void setValorLargura(float valorLargura) {
		this.valorLargura = valorLargura;
	}
	

	public float getValorDiametro() {
		return valorDiametro;
	}


	public void setValorDiametro(float valorDiametro) {
		this.valorDiametro = valorDiametro;
	}


	public int getCodigoFormato() {
		return codigoFormato;
	}


	public void setCodigoFormato(int codigoFormato) {
		this.codigoFormato = codigoFormato;
	}


	public boolean isPromocao() {
		return isPromocao;
	}

	public void setPromocao(boolean isPromocao) {
		this.isPromocao = isPromocao;
	}

}
