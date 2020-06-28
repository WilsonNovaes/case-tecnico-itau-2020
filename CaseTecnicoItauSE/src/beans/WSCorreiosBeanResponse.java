package beans;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;



public class WSCorreiosBeanResponse {
	
	private String codigo;
	private String valor;
	private String prazoEntrega;
	private String valorSemAdicionais;
	private String valorMaoPropria;
	private String valorAvisoRecebimento;
	private String valorValorDeclarado;
	private String entregaDomiciliar;
	private String entregaSabado;
	private String obsFim;
	private String erro;
	private String msgErro;
	
	public WSCorreiosBeanResponse(String xmlResponse) {
		DocumentBuilder builder;
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			src.setCharacterStream(new StringReader(xmlResponse));

			Document doc = builder.parse(src);
			
			codigo 					= doc.getElementsByTagName("Codigo").item(0).getTextContent();
			valor 					= doc.getElementsByTagName("Valor").item(0).getTextContent();
			prazoEntrega 			= doc.getElementsByTagName("PrazoEntrega").item(0).getTextContent();
			valorSemAdicionais 		= doc.getElementsByTagName("ValorSemAdicionais").item(0).getTextContent();
			valorMaoPropria 		= doc.getElementsByTagName("ValorMaoPropria").item(0).getTextContent();
			valorAvisoRecebimento 	= doc.getElementsByTagName("ValorAvisoRecebimento").item(0).getTextContent();
			valorValorDeclarado 	= doc.getElementsByTagName("ValorValorDeclarado").item(0).getTextContent();
			entregaDomiciliar 		= doc.getElementsByTagName("EntregaDomiciliar").item(0).getTextContent();
			entregaSabado 			= doc.getElementsByTagName("EntregaSabado").item(0).getTextContent();
			obsFim 					= doc.getElementsByTagName("obsFim").item(0).getTextContent();
			erro 					= doc.getElementsByTagName("Erro").item(0).getTextContent();
			msgErro 				= doc.getElementsByTagName("MsgErro").item(0).getTextContent();
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getPrazoEntrega() {
		return prazoEntrega;
	}
	public void setPrazoEntrega(String prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}
	public String getValorSemAdicionais() {
		return valorSemAdicionais;
	}
	public void setValorSemAdicionais(String valorSemAdicionais) {
		this.valorSemAdicionais = valorSemAdicionais;
	}
	public String getValorMaoPropria() {
		return valorMaoPropria;
	}
	public void setValorMaoPropria(String valorMaoPropria) {
		this.valorMaoPropria = valorMaoPropria;
	}
	public String getValorAvisoRecebimento() {
		return valorAvisoRecebimento;
	}
	public void setValorAvisoRecebimento(String valorAvisoRecebimento) {
		this.valorAvisoRecebimento = valorAvisoRecebimento;
	}
	public String getValorValorDeclarado() {
		return valorValorDeclarado;
	}
	public void setValorValorDeclarado(String valorValorDeclarado) {
		this.valorValorDeclarado = valorValorDeclarado;
	}
	public String getEntregaDomiciliar() {
		return entregaDomiciliar;
	}
	public void setEntregaDomiciliar(String entregaDomiciliar) {
		this.entregaDomiciliar = entregaDomiciliar;
	}
	public String getEntregaSabado() {
		return entregaSabado;
	}
	public void setEntregaSabado(String entregaSabado) {
		this.entregaSabado = entregaSabado;
	}
	public String getObsFim() {
		return obsFim;
	}
	public void setObsFim(String obsFim) {
		this.obsFim = obsFim;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	public String getMsgErro() {
		return msgErro;
	}
	public void setMsgErro(String msgErro) {
		this.msgErro = msgErro;
	}
	
	
	

}
