import static org.junit.Assert.assertEquals;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import org.junit.Test;

import com.MeuTeatroPortal.servlets.CadastrarEspetaculoServlet;
import com.MeuTeatroPortal.servlets.LoginServlet;

import util.EmailJava;

public class teste {

	@Test
	public void test() {
		CadastrarEspetaculoServlet c = new CadastrarEspetaculoServlet();
		String formatadoParaBanco = "2017-10-31";
		
//		assertEquals(formatadoParaBanco,c.ajustaData("31/10/2017"));
	}

	
	@Test
	public void testEnvioEmailExterno(){
		
		EmailJava e = new EmailJava();
		
		
		
	}
	
	
	@Test
	public void testaCriptografia(){
		String senha = "456";
		String senhaHex = null;
		try {
			
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = md.digest(senha.getBytes());
			StringBuilder sb = new StringBuilder();
			for(byte b: messageDigest){
				sb.append(String.format("%02X", 0xFF & b));
			}
			
			
			
			 senhaHex = sb.toString();
			
			
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		assertEquals(senha,senhaHex);
	
		
	}	
	
	@Test
	public void semEspaco(){
		String em = "maria betania lokona";
		String semEspaco = em.replaceAll(" ","");
		System.out.println("valor da string sem espaços:" + em);
assertEquals("mariabetanialokona",semEspaco);
	}
	
	
		@Test
		public void testContainChar(){
			
			
			String a = "a/lex87ui";
			assertEquals(true,a.contains("/"));
			
			
		}
		
		
	}
	
	

