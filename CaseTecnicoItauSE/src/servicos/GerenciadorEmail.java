package servicos;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import beans.Carrinho;
import beans.Checkout;

public class GerenciadorEmail {
	
	
	public void enviaEmail(String emailDestinatario, Carrinho carrinho, Checkout checkout) {
		try {
			Properties props = new Properties();
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.socketFactory.port", "465");
		    props.put("mail.smtp.socketFactory.class", 
		    "javax.net.ssl.SSLSocketFactory");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.port", "465");
		 
		    Session session = Session.getDefaultInstance(props,
		      new javax.mail.Authenticator() {
		           protected PasswordAuthentication getPasswordAuthentication() 
		           {
		                 return new PasswordAuthentication("emailparatestes9876543210@gmail.com", "emailteste123321");
		           }
		      });
		    session.setDebug(true);
		 
		    try {
		 
		      Message message = new MimeMessage(session);
		      message.setFrom(new InternetAddress("emailparatestes9876543210@gmail.com")); 
		 
		      Address[] toUser = InternetAddress.parse(emailDestinatario);  
		 
		      message.setRecipients(Message.RecipientType.TO, toUser);
		      message.setSubject("Amazônia R.C, Inc. - Itau Case Tecnico Wilson");
		      
		      StringBuilder corpoTexto = new StringBuilder();
		      corpoTexto.append("Compra efetuada com sucesso !\r\n");
		      corpoTexto.append("\r\n");
		      corpoTexto.append("Segue abaixo os itens comprados:\r\n");
		      if (carrinho!=null)
		      for (int p = 0 ; p < carrinho.getLsProdutosSelecionados().getSize(); p++) 
		    	  corpoTexto.append( carrinho.getLsProdutosSelecionados().get(p).getNomeProduto()+"\r\n");
		      
		      corpoTexto.append("\r\n");
		      if (checkout!=null)
		    	  corpoTexto.append("Total Carrinho: R$ "+checkout.getValorTotalCarrinho()+"\r\n");
		      
		      message.setText(corpoTexto.toString());
		 
		      
		      
		      Transport.send(message);
		 
		      System.out.println("Email Enviado com sucesso!!!");
		 
		     } catch (MessagingException e) {
		        throw new RuntimeException(e);
		    }
		} catch (Exception ex) {
			System.out.println("Email seria enviado aqui, entretanto ocorreu algum erro ! "+ex.getMessage());
		}
		 	
	}

}