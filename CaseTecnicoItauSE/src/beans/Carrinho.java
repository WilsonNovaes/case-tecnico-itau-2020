package beans;

import javax.swing.DefaultListModel;

public class Carrinho {
	
	private DefaultListModel<ProdutoSelecionado> lsProdutosSelecionados;
	
	public Carrinho() {
		lsProdutosSelecionados = new DefaultListModel<>();
	}
	
	public boolean isEmpty() {
		return lsProdutosSelecionados.isEmpty();
	}
	
	public void adicionarProdutoSelecionado(ProdutoSelecionado prodSel) {
		getLsProdutosSelecionados().addElement(prodSel);		
	}
	
	public void removerProdutoSelecionado(ProdutoSelecionado prodSel) {
		getLsProdutosSelecionados().removeElement(prodSel);		
	}
	
	public void limparProdutos() {
		getLsProdutosSelecionados().removeAllElements();	
	}

	
	public DefaultListModel<ProdutoSelecionado> getLsProdutosSelecionados() {
		return lsProdutosSelecionados;
	}

	public void setLsProdutosSelecionados(DefaultListModel<ProdutoSelecionado> lsProdutosSelecionados) {
		this.lsProdutosSelecionados = lsProdutosSelecionados;
	}
	
	


}
