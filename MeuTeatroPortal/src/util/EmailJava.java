package util;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.HtmlEmail;


public class EmailJava {
	HtmlEmail email;
	
public EmailJava() {
	email = new HtmlEmail();	
	configure();
	}
	
private void configure(){
	email.setHostName("smtp.googlemail.com");
	email.setSmtpPort(465);
	email.setAuthentication("alex.kidxx@gmail.com", "qwertyuioP");//colocar o email enviador aqui
	email.setSSLOnConnect(true);
	
}

	public void enviarEmail(String from, String subject, String mensagem, String to){
	try{	

	email.setFrom(from);
	email.setSubject(subject);
	email.setMsg(mensagem);
	email.addTo(to);
	email.addReplyTo("contato@meuteatro.com");
	
	email.setHtmlMsg(mensagem);
	
	
	//"<html>Bem vindo ao Meu Teatro!</br><a href='http://www.uol.com'>Clique aqui para configurar seu acesso</a></html>" o cara que tava indo e funfando
	
	
	
	email.send();
	
	
	}catch (EmailException ex){
	
		Logger.getLogger(EmailJava.class.getName()).log(Level.SEVERE, null, ex);
	
	}
	
	
	
	
	
	
	
	}
	
	
	
	
	
	
	
	
	

}
