package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import beans.Carrinho;
import beans.Checkout;
import beans.Dados;
import beans.Produto;
import beans.ProdutoSelecionado;
import beans.ServicoCorreios;
import servicos.GerenciadorEmail;

public class TelaPrototipo {
	
	protected JFrame framePrincipal;
	protected JTabbedPane tabPanel;
	protected JLabel lblTitulo;
	protected JList<Produto> lstProdutos;
	protected JList<ProdutoSelecionado> lstCarrinho;
	protected JComboBox<ServicoCorreios> cbxServicoCorreios;
	protected Carrinho carrinho;
	protected Checkout checkoutAux;
	
	protected JButton btnRemover;
	protected JButton btnAdicionar;
	protected JButton btnLimpar;
	protected JButton btnCheckout;
	protected JButton btnCompra;
	
	protected JTextField txtlblNomeProduto;
	protected JTextField txtTipoProduto;
	protected JTextField txtValorProduto;
	protected JTextField txtPromocaoProduto;
	
	protected JTextField txtCepOrigem;
	protected JTextField txtCepDestino;
	protected JTextField txtEmail;
	protected JTextField txtCupomDesconto;
	
	protected JCheckBox chkDigital;


	public TelaPrototipo() {
		carrinho = new Carrinho();
		
		
		framePrincipal = new JFrame("Amazônia R.C, Inc.");
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		framePrincipal.setSize(600, 600);
		
		lblTitulo = new JLabel("Amazônia R.C, Inc.");
		lblTitulo.setFont(new Font("Arial",0,33));
		lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		
		
		// TAB de Produtos ####################################
		JPanel pnlProdutos = new JPanel();
		pnlProdutos.setLayout(null);
		
		// CATALOGO DE PRODUTOS:
		lstProdutos = new JList<>(Produto.carregaProdutosExemplosTela());
		lstProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstProdutos.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		lstProdutos.setCellRenderer(new ListRendererProduto());
		lstProdutos.setFixedCellHeight(50);
		lstProdutos.setFixedCellWidth(160);
		lstProdutos.setVisibleRowCount(-1);
		
		JScrollPane listScroller = new JScrollPane(lstProdutos);
		listScroller.setPreferredSize(new Dimension(250, 80));
		listScroller.setSize(530, 120);
		listScroller.setLocation(20, 10);
		pnlProdutos.add(listScroller);
		
		
		// BOTÕES:
		btnAdicionar = new JButton("Adicionar no Carrinho");
		btnAdicionar.setSize(200,30);
		btnAdicionar.setLocation(20, 150);
		pnlProdutos.add(btnAdicionar);
		
		
		// DESCRIÇÃO DO PRODUTO:
		JLabel lblNomeProduto = new JLabel("Descrição: ");
		lblNomeProduto.setSize(150,20);
		lblNomeProduto.setLocation(20,200);
		pnlProdutos.add(lblNomeProduto);
		
		txtlblNomeProduto = new JTextField();
		txtlblNomeProduto.setSize(300,20);
		txtlblNomeProduto.setLocation(200, 200);
		txtlblNomeProduto.setEnabled(false);
		txtlblNomeProduto.setDisabledTextColor(Color.BLACK);
		pnlProdutos.add(txtlblNomeProduto);
		
		
		JLabel lblTipoProduto = new JLabel("Tipo do Produto: ");
		lblTipoProduto.setSize(150,20);
		lblTipoProduto.setLocation(20,230);
		pnlProdutos.add(lblTipoProduto);
		
		txtTipoProduto = new JTextField();
		txtTipoProduto.setSize(300,20);
		txtTipoProduto.setLocation(200, 230);
		txtTipoProduto.setEnabled(false);
		txtTipoProduto.setDisabledTextColor(Color.BLACK);
		pnlProdutos.add(txtTipoProduto);
		
		
		JLabel lblValorProduto = new JLabel("Valor: ");
		lblValorProduto.setSize(150,20);
		lblValorProduto.setLocation(20,260);
		pnlProdutos.add(lblValorProduto);
		
		txtValorProduto = new JTextField();
		txtValorProduto.setSize(300,20);
		txtValorProduto.setLocation(200, 260);
		txtValorProduto.setEnabled(false);
		txtValorProduto.setDisabledTextColor(Color.BLACK);
		pnlProdutos.add(txtValorProduto);
		
		
		JLabel lblPromocaoProduto = new JLabel("Está em Promoção?: ");
		lblPromocaoProduto.setSize(150,20);
		lblPromocaoProduto.setLocation(20,290);
		pnlProdutos.add(lblPromocaoProduto);
		
		txtPromocaoProduto = new JTextField();
		txtPromocaoProduto.setSize(300,20);
		txtPromocaoProduto.setLocation(200, 290);
		txtPromocaoProduto.setEnabled(false);
		txtPromocaoProduto.setDisabledTextColor(Color.BLACK);
		pnlProdutos.add(txtPromocaoProduto);
		
		
		
		chkDigital = new JCheckBox("Receber em formato digital?");
		chkDigital.setSize(250,20);
		chkDigital.setLocation(20,350);
		pnlProdutos.add(chkDigital);
		
		// TAB de Carrinho ####################################
		JPanel pnlCarrinho = new JPanel();
		pnlCarrinho.setLayout(null);
		
		lstCarrinho = new JList<>(carrinho.getLsProdutosSelecionados());
		
		lstCarrinho.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstCarrinho.setLayoutOrientation(JList.VERTICAL);
		lstCarrinho.setCellRenderer(new ListRendererProduto());
		lstCarrinho.setFixedCellHeight(30);
		lstCarrinho.setVisibleRowCount(-1);
		
		
		JScrollPane listScrollerCarrinho = new JScrollPane(lstCarrinho);
		listScrollerCarrinho.setPreferredSize(new Dimension(250, 80));
		listScrollerCarrinho.setSize(530, 120);
		listScrollerCarrinho.setLocation(20, 10);
		pnlCarrinho.add(listScrollerCarrinho);
		
		
		
		
		JLabel lblCepOrigem = new JLabel("CEP origem: ");
		lblCepOrigem.setSize(150,20);
		lblCepOrigem.setLocation(20,150);
		pnlCarrinho.add(lblCepOrigem);
		
		txtCepOrigem = new JTextField();
		txtCepOrigem.setSize(300,20);
		txtCepOrigem.setLocation(200, 150);
		pnlCarrinho.add(txtCepOrigem);
		
		JLabel lblCepDestino = new JLabel("CEP Destino: ");
		lblCepDestino.setSize(150,20);
		lblCepDestino.setLocation(20,180);
		pnlCarrinho.add(lblCepDestino);
		
		txtCepDestino = new JTextField();
		txtCepDestino.setSize(300,20);
		txtCepDestino.setLocation(200, 180);
		pnlCarrinho.add(txtCepDestino);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setSize(150,20);
		lblEmail.setLocation(20,210);
		pnlCarrinho.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setSize(300,20);
		txtEmail.setLocation(200, 210);
		pnlCarrinho.add(txtEmail);
		
		
		JLabel lblServico = new JLabel("Servico: ");
		lblServico.setSize(150,20);
		lblServico.setLocation(20,240);
		pnlCarrinho.add(lblServico);
		
		cbxServicoCorreios = new JComboBox<ServicoCorreios>(ServicoCorreios.retornaListaServicos().toArray(new ServicoCorreios[0]));
		cbxServicoCorreios.setSize(300,20);
		cbxServicoCorreios.setLocation(200, 240);
		cbxServicoCorreios.setRenderer(new DefaultListCellRenderer() {
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			@Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if(value instanceof ServicoCorreios){
                	ServicoCorreios serv = (ServicoCorreios) value;
                    setText(serv.getNomeServico());
                }
                return this;
            }
        } );
		cbxServicoCorreios.setSelectedIndex(10);
		pnlCarrinho.add(cbxServicoCorreios);
		
		
		JLabel lblCupomDesconto = new JLabel("Cupom Desconto: ");
		lblCupomDesconto.setSize(150,20);
		lblCupomDesconto.setLocation(20,270);
		pnlCarrinho.add(lblCupomDesconto);
		
		txtCupomDesconto = new JTextField();
		txtCupomDesconto.setSize(300,20);
		txtCupomDesconto.setLocation(200, 270);
		pnlCarrinho.add(txtCupomDesconto);
		
		
		//TEste
		txtCepOrigem.setText("04094-050");
		txtCepDestino.setText("90619-900");
		txtCupomDesconto.setText("desconto1");
		
		
		
		// BOTOES:
		btnRemover = new JButton("Remover Item");
		btnRemover.setSize(200,30);
		btnRemover.setLocation(20, 300);
		pnlCarrinho.add(btnRemover);
		
		btnLimpar = new JButton("Limpar Carrinho");
		btnLimpar.setSize(200,30);
		btnLimpar.setLocation(20, 340);
		pnlCarrinho.add(btnLimpar);
		
		btnCheckout = new JButton("Checkout");
		btnCheckout.setSize(200,70);
		btnCheckout.setLocation(300, 300);
		pnlCarrinho.add(btnCheckout);
		
		
		tabPanel = new JTabbedPane();
		tabPanel.addTab("Produtos", null, pnlProdutos, "Produtos" );
		tabPanel.addTab("Carrinho", null, pnlCarrinho, "Carrinho" );
		
		
		framePrincipal.add(lblTitulo, BorderLayout.PAGE_START);
		framePrincipal.add(tabPanel);
		
		carregaAcoesTelaPrincipal();
		
	}
	
	private void showModalCheckout(Checkout checkout) {
		checkoutAux = checkout;
		JFrame frameCheckout = new JFrame("Checkout");
		frameCheckout.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameCheckout.setSize(420, 450);
		
		JPanel pnlCheckout = new JPanel();
		pnlCheckout.setLayout(null);
		
		JLabel lblTotalFrete = new JLabel("Valor total do Frete: ");
		lblTotalFrete.setSize(150,20);
		lblTotalFrete.setLocation(20,30);
		pnlCheckout.add(lblTotalFrete);
		
		JTextField txtTotalFrete = new JTextField();
		txtTotalFrete.setSize(180,20);
		txtTotalFrete.setLocation(200, 30);
		txtTotalFrete.setEnabled(false);
		txtTotalFrete.setDisabledTextColor(Color.BLACK);
		pnlCheckout.add(txtTotalFrete);
		
		txtTotalFrete.setText(String.valueOf(checkout.getValorTotalFrete()));
		
		
		JLabel lblTotalProdutos = new JLabel("Valor total dos Produtos: ");
		lblTotalProdutos.setSize(150,20);
		lblTotalProdutos.setLocation(20,60);
		pnlCheckout.add(lblTotalProdutos);
		
		JTextField txtTotalProdutos = new JTextField();
		txtTotalProdutos.setSize(180,20);
		txtTotalProdutos.setLocation(200, 60);
		txtTotalProdutos.setEnabled(false);
		txtTotalProdutos.setDisabledTextColor(Color.BLACK);
		pnlCheckout.add(txtTotalProdutos);
		
		txtTotalProdutos.setText(String.valueOf(checkout.getValorTotalProdutos()));
		
		
		JLabel lblTotalCarrinho = new JLabel("Valor total do Carrinho: ");
		lblTotalCarrinho.setSize(150,20);
		lblTotalCarrinho.setLocation(20,90);
		pnlCheckout.add(lblTotalCarrinho);
		
		JTextField txtTotalCarrinho = new JTextField();
		txtTotalCarrinho.setSize(180,20);
		txtTotalCarrinho.setLocation(200, 90);
		txtTotalCarrinho.setEnabled(false);
		txtTotalCarrinho.setDisabledTextColor(Color.BLACK);
		pnlCheckout.add(txtTotalCarrinho);
		
		txtTotalCarrinho.setText(String.valueOf(checkout.getValorTotalCarrinho()));
		
		
		JLabel lblConsole = new JLabel("Mensagem Servidor: ");
		lblConsole.setSize(150,20);
		lblConsole.setLocation(20,120);
		pnlCheckout.add(lblConsole);
		
		JTextArea txaConsole = new JTextArea();
		txaConsole.setEnabled(false);
		txaConsole.setDisabledTextColor(Color.BLACK);
		
		JScrollPane listScrollerConsole = new JScrollPane(txaConsole);
		listScrollerConsole.setPreferredSize(new Dimension(210, 40));
		listScrollerConsole.setSize(360, 100);
		listScrollerConsole.setLocation(20, 150);
		pnlCheckout.add(listScrollerConsole);
		
		boolean habiltaCompra = true;
		
		if (checkout.getErroMensagem()!=null && checkout.getErroMensagem()!="") {
			txaConsole.setText(checkout.getErroMensagem() +"\r\nÉ necessário regularizar as ocorrencias para efetuar a compra.");
			habiltaCompra = false;
		} else {
			txaConsole.setText("OK");
		}
		
		
		btnCompra = new JButton("Comprar");
		btnCompra.setSize(360,40);
		btnCompra.setLocation(20, 260);
		btnCompra.setEnabled(habiltaCompra);
		pnlCheckout.add(btnCompra);
		
		carregaAcoesCheckout();
		
		frameCheckout.add(pnlCheckout);
		frameCheckout.setVisible(true);
		
	}
	
	
	public void show() {
		framePrincipal.setVisible(true);
	}
	
	
	
	private void carregaAcoesCheckout() {
		btnCompra.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					GerenciadorEmail gemail = new GerenciadorEmail();
					gemail.enviaEmail(txtEmail.getText(), carrinho, checkoutAux);
					JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso! \r\nEmail enviado!");
				} catch (Exception err) {
					int dialogButton = JOptionPane.OK_OPTION;
					JOptionPane.showMessageDialog(null, "Ocorreu algum erro! \r\n"+err.getMessage(),"Erro",dialogButton);
				}
				
			}
		});
		
	}
	
	private void carregaAcoesTelaPrincipal() {
		btnAdicionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Produto produtoSelecionadoListaProduto = lstProdutos.getSelectedValue();
				if (produtoSelecionadoListaProduto != null) {
					ProdutoSelecionado produtoSelecionado = new ProdutoSelecionado(produtoSelecionadoListaProduto);
					produtoSelecionado.setDigital(chkDigital.isSelected());
					carrinho.adicionarProdutoSelecionado(produtoSelecionado);
				}
			}
		});
		
		
		btnRemover.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProdutoSelecionado produtoSelecionadoCarrinho = lstCarrinho.getSelectedValue();
				if (produtoSelecionadoCarrinho != null) {
					carrinho.removerProdutoSelecionado(produtoSelecionadoCarrinho);
				}
			}
		});
		
		btnLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Tem certeza que deseja limpar todos os registros do carrinho?","Atenção",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					carrinho.limparProdutos();
				}
			}
		});
		
		
		lstProdutos.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				 if (!e.getValueIsAdjusting()) {
					 txtlblNomeProduto.setText(lstProdutos.getSelectedValue().getNomeProduto());
					 txtTipoProduto.setText(lstProdutos.getSelectedValue().getTipoProduto());
					 txtValorProduto.setText(String.valueOf(lstProdutos.getSelectedValue().getValorProduto()));
					 if (lstProdutos.getSelectedValue().isPromocao()) {
						 txtPromocaoProduto.setText("Sim");
					 } else {
						 txtPromocaoProduto.setText("Não");
					 }
				 }
				
				
			}
		});
		
		btnCheckout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!carrinho.isEmpty()) {
					Dados dados = new Dados();
					dados.setCepOrigem(txtCepOrigem.getText());
					dados.setCepDestino(txtCepDestino.getText());
					dados.setCupomDesconto(txtCupomDesconto.getText());
					dados.setServicoCorreios((ServicoCorreios) cbxServicoCorreios.getSelectedItem());
					
					Checkout checkout = new Checkout(carrinho, dados);
					showModalCheckout(checkout);
				} else {
					int dialogButton = JOptionPane.OK_OPTION;
					JOptionPane.showMessageDialog(null, "O carrinho está vazio !","Atenção",dialogButton);
				}

			}
		});
	}
	
	/*
	public DefaultListModel<Produto> getlsmProdutos() {
		return lsmProdutos;
	}

	public void setlsmProdutos(DefaultListModel<Produto> lsmProdutos) {
		this.lsmProdutos = lsmProdutos;
	}
	*/


}


class ListRendererProduto extends DefaultListCellRenderer  {

	private static final long serialVersionUID = 1L;

	public Component getListCellRendererComponent(@SuppressWarnings("rawtypes") JList list, Object value,
		      int index, boolean isSelected, boolean cellHasFocus) {
		    super.getListCellRendererComponent(list, value, index, isSelected,
		        cellHasFocus);
		    if (value instanceof Produto) {
		    	Produto produto = (Produto) value;
		    	setText(produto.getNomeProduto() +(produto.isPromocao()?" (Promoção)":""));
		    } 
		    
		   if (value instanceof ProdutoSelecionado) {
			   ProdutoSelecionado produtoSel = (ProdutoSelecionado) value;
		       setText(produtoSel.getNomeProduto() +(produtoSel.isDigital()?" (digital)":""));
		   }

		    return this;
		  }
}

