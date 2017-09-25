package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cifrador {

	public static String criptografar(String entrada){
		
		String saida = null;
		try {
			
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte messageDigest[] = md.digest(entrada.getBytes());
			StringBuilder sb = new StringBuilder();
			for(byte b: messageDigest){
				sb.append(String.format("%02X", 0xFF & b));
			}
			
			 saida = sb.toString();
			
			
			
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		return saida;
	}
	
	

}
