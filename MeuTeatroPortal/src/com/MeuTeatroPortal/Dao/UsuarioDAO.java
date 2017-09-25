package com.MeuTeatroPortal.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.MeuTeatroPortal.Entidades.Teatro;
import com.MeuTeatroPortal.Entidades.Usuario;

import util.Cifrador;
import util.EmailJava;

public class UsuarioDAO {

	Connection c = new ConnectionFactory().getConnection();

	public void cadastrar(Usuario u) {
	
	if(u.getNivelDeAcesso()==0 || u.getNivelDeAcesso() == 1){
	
		String sql="insert into meuteatroportal.usuarios(nome,email,teatro_pertencente,pergunta_secreta,nivel_de_acesso,ativo_inativo,telefone)values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getNome());
			ps.setString(2, u.getEmail());
			ps.setInt(3,u.getTeatroPertencente());
			ps.setString(4,Cifrador.criptografar(u.getEmail()));
			ps.setInt(5, u.getNivelDeAcesso());
			ps.setBoolean(6, u.isAtivo());
			ps.setString(7, u.getTelefone());
			
			ps.executeUpdate();
			gerarEmailPrimeiroAcesso(u);
			
		System.out.println("cadastro de usuario nosso para criar key user ou adm");

		} catch (SQLException e) {
			System.out.println("problemas para cadastrar usuario no banco");
			e.printStackTrace();
		}
	
	}else {
		
		String sql="insert into meuteatroportal.usuarios(nome,email,teatro_pertencente,pergunta_secreta,nivel_de_acesso,ativo_inativo,telefone)values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, u.getNome());
			ps.setString(2, u.getEmail());
			ps.setInt(3,u.getTeatroPertencente());
			ps.setString(4,Cifrador.criptografar(u.getEmail()));
			ps.setInt(5,2);
			ps.setBoolean(6, u.isAtivo());
			ps.setString(7, u.getTelefone());
			
			ps.executeUpdate();
			gerarEmailPrimeiroAcesso(u);
			
		System.out.println("cadastro de usuario para criar user comum tipo 2");

		} catch (SQLException e) {
			System.out.println("problemas para cadastrar usuario comum no banco");
			e.printStackTrace();
		}

	}
	}

	public void gerarEmailPrimeiroAcesso(Usuario u) {
		EmailJava primeiroAcesso = new EmailJava();
		
		String emailParametro = Cifrador.criptografar(u.getEmail());
		String mensage = "<html>Bem vindo ao Meu Teatro!</br><a href=\"http://localhost:8080/MeuTeatroPortal/PrimeiroAcessoServlet?ativacao="+emailParametro+"\" >Clique aqui para configurar seu acesso</a></html>";
		primeiroAcesso.enviarEmail("contato@meuteatro.com", "Bem vindo ao Meu Teatro", mensage, u.getEmail());
		
		
	}

	public ArrayList<Usuario> todosUsuarios() {
		String sql ="select * from usuarios";
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				
				Usuario u = new Usuario();
				
					u.setId(rs.getInt("id_usuario"));
					u.setNome(rs.getString("nome"));
					u.setEmail(rs.getString("email"));
					u.setTeatroPertencente(rs.getInt("teatro_pertencente"));
					u.setNivelDeAcesso(rs.getInt("nivel_de_acesso"));
					u.setAtivo(rs.getBoolean("ativo_inativo"));
					u.setTelefone(rs.getString("telefone"));
					
				
					
					
					listaUsuario.add(u);
				  
	            } 
			System.out.println("Lista de espetaculos advindo do banco e seus dados:" + listaUsuario);
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return listaUsuario;

	}

	public  void cadastrarUsuarioZero(Teatro t) {
		TeatroDAO td = new TeatroDAO();
		String em = t.getNomeTeatro();
		String semEspaco = em.replaceAll(" ","");
		String senha = Cifrador.criptografar(semEspaco.toLowerCase()+t.getUf());
		
		String sql="insert into meuteatroportal.usuarios(nome,email,teatro_pertencente,nivel_de_acesso,senha,ativo_inativo,pergunta_secreta)values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, t.getNomeTeatro());
			ps.setString(2, semEspaco.toLowerCase() +"@meuteatro.com.br");
			ps.setInt(3,td.buscarTeatroPorNome(t.getNomeTeatro()));
			ps.setInt(4,1);
			ps.setString(5,senha);
			ps.setBoolean(6, true);
			
			
			ps.executeUpdate();
			
			
		System.out.println("usuario zero desse teatro");

		} catch (SQLException e) {
			System.out.println("problemas para cadastrar usuario zero no banco");
			e.printStackTrace();
		}
	}

	public void inativar(String id) {
		int idUsuario = Integer.parseInt(id);
		String sql = "update usuarios set ativo_inativo = 0 where id_usuario = ?";
		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, idUsuario);
			ps.executeUpdate();
			
		}
		catch(SQLException e){
			System.out.println("problemas ao mudar o status");
			e.printStackTrace();
		}
		
	}

	public void ativar(String id) {
		int idUsuario = Integer.parseInt(id);
		String sql = "update usuarios set ativo_inativo = 1 where id_usuario = ?";
		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, idUsuario);
			ps.executeUpdate();
			
		}
		catch(SQLException e){
			System.out.println("problemas ao mudar o status");
			e.printStackTrace();
		}
		
	}

	public String buscaIdPorNome(String emailCriptado) {
		
		String email = null;
		
		String sql ="select email from usuarios where pergunta_secreta = ?";
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, emailCriptado);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
		
				email = rs.getString("email");
		        } 
			System.out.println("email retornado do banco para primeiro acesso!");
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	
		return email;
		
	}

	public void setaSenha(String senha, String pergunta, String resposta, int id) {
		
	System.out.println("tudo aqui tinha q ser null: "+ senha + pergunta + resposta + id);
		String sql = "UPDATE usuarios SET pergunta_secreta = ?, resposta_secreta = ?, ativo_inativo = ?,senha = ? WHERE id_usuario = ?";
		try{
			PreparedStatement ps = c.prepareStatement(sql);
			
		ps.setString(1, pergunta);
		ps.setString(2, resposta);
		ps.setBoolean(3, true);
		ps.setString(4, senha);
		ps.setInt(5, id);
			
			
		
			
			ps.execute();
			
		}
		catch(SQLException e){
			System.out.println("problemas ao setar senha nova");
			e.printStackTrace();
		}
		
	}

	public Integer getId(String email) {
		ResultSet rs = null;
		Integer id = null;
		Integer retorno= null;
		String sql = "select id_usuario from usuarios where email = ?";
		try{
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				id = rs.getInt("id_usuario");
				retorno = id;
		        } 
			
		}
		catch(SQLException e){
			System.out.println("problemas ao buscar email no banco");
			e.printStackTrace();
		
		}
		return retorno;
		

	
	}

	public void prepararReset(int id, String email) {
		
		String sql = "UPDATE usuarios SET pergunta_secreta = ? WHERE id_usuario = ?";
		try{
			PreparedStatement ps = c.prepareStatement(sql);
			
		ps.setString(1, Cifrador.criptografar(email));
		ps.setInt(2, id);
	
			ps.execute();
			
		}
		catch(SQLException e){
			System.out.println("problemas ao setar email criptado");
			e.printStackTrace();
		}
		
		
	}

	public void atualizarDadoDoUsuario(String nome, String telefone,int id) {
	String sql = "update usuarios set nome = ?,telefone=?  where id_usuario = ?";
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1,nome);
			ps.setString(2, telefone);
			ps.setInt(3, id);
			ps.executeUpdate();
			} catch (SQLException e) {
			System.out.println("problemas para atualizar dados de usuario espetaculo");
			e.printStackTrace();
		}

	
	}
	}



		
	


	

