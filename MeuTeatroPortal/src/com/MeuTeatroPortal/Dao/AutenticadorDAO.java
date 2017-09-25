package com.MeuTeatroPortal.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.MeuTeatroPortal.Entidades.Usuario;

import util.Cifrador;




public class AutenticadorDAO {
	
	Connection c = new ConnectionFactory().getConnection();

	public Usuario autenticar(String email, String senha) {
	
		
		//criptografar a senha aqui antes do select, aplicar o resultado dele a o que tá no banco
		
		
		String sql ="SELECT nome,email,id_usuario,teatro_pertencente,nivel_de_acesso,ativo_inativo,telefone FROM usuarios WHERE email = ? and senha =?";
	
		Usuario u = new Usuario();
		ResultSet rs = null;
		
		System.out.println("");	
		
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, Cifrador.criptografar(senha));// e aqui tbm, 
			rs = ps.executeQuery();
			
			while(rs.next()) {
	                u.setNome(rs.getString("nome"));
	                u.setEmail(rs.getString("email"));
	                u.setId(rs.getInt("id_usuario"));
	                u.setTeatroPertencente(rs.getInt("teatro_pertencente"));
	                u.setNivelDeAcesso((byte) rs.getInt("nivel_de_acesso"));
	                u.setAtivo(rs.getBoolean("ativo_inativo"));
	                u.setTelefone(rs.getString("telefone"));
	                
	            } 
			System.out.println("Usuario vindo do banco e seus dados:" + u);
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		return u;
	
	}


	public Usuario getPerguntaSecreta(String emailLogador) {
		String sql ="SELECT pergunta_secreta,resposta_secreta FROM usuarios WHERE email = ?";
		
			Usuario u = new Usuario();
			ResultSet rs = null;
	
			try {
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setString(1, emailLogador);
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
		             
		               u.setPerguntaSecreta(rs.getString("pergunta_secreta"));
		               u.setRespostaSecreta(rs.getString("resposta_secreta"));
		                
		            } 
				
	
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			return u;
		
			}
		}
	
	
		

