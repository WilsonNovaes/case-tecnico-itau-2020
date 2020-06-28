package beans;

public class ProdutoSelecionado extends Produto {
	
	private boolean isDigital;
	private float valorFrete;
	private boolean descontoAplicado = false;
	
	public ProdutoSelecionado(Produto _produto) {
		super(
				_produto.getNomeProduto(), 
				_produto.getTipoProduto(),
				_produto.getValorProduto(),
				_produto.getValorPeso(),
				_produto.getValorComprimento(), 
				_produto.getValorAltura(), 
				_produto.getValorLargura(), 
				_produto.getValorDiametro(),
				_produto.getCodigoFormato(), 
				_produto.isPromocao()
				);
		
	}
	


	public boolean isDigital() {
		return isDigital;
	}

	public void setDigital(boolean isDigital) {
		this.isDigital = isDigital;
	}

	public float getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(float valorFrete) {
		this.valorFrete = valorFrete;
	}


	public boolean isDescontoAplicado() {
		return descontoAplicado;
	}


	public void setDescontoAplicado(boolean descontoAplicado) {
		this.descontoAplicado = descontoAplicado;
	}
	
	

}
