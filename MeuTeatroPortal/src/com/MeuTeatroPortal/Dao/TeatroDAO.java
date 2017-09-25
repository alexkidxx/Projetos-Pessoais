package com.MeuTeatroPortal.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.MeuTeatroPortal.Entidades.Teatro;
import com.MeuTeatroPortal.Entidades.Usuario;

public class TeatroDAO {
	Connection c = new ConnectionFactory().getConnection();
	
	
	public void cadastrar(Teatro t) {
		UsuarioDAO uDao = new UsuarioDAO();
		String sql="insert into meuteatroportal.teatro(nome_teatro,cnpj,razao_social,endereco,cidade,uf,cep,telefone,ativo)values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
		
			ps.setString(1, t.getNomeTeatro());
			ps.setString(2, t.getCnpj());
			ps.setString(3,t.getRazaoSocial());
			ps.setString(4, t.getEndereco());
			ps.setString(5, t.getCidade());
			ps.setString(6, t.getUf());
			ps.setInt(7, t.getCep());
			ps.setString(8, t.getTelefone());
			ps.setInt(9, t.getAtivo());
			
			ps.executeUpdate();
			uDao.cadastrarUsuarioZero(t);
			

		} catch (SQLException e) {
			System.out.println("problemas para cadastrar teatro no banco");
			e.printStackTrace();
		}
		
	}

	
	public ArrayList<Teatro> todosTeatros() {
		String sql ="select * from teatro";
		ArrayList<Teatro> listaTeatro = new ArrayList<Teatro>();
		
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				Teatro t = new Teatro();
			t.setIdTeatro(rs.getInt("id_teatro"));
			t.setNomeTeatro(rs.getString("nome_teatro"));
			t.setCnpj(rs.getString("cnpj"));
			t.setRazaoSocial(rs.getString("razao_social"));
			t.setEndereco(rs.getString("endereco"));
			t.setCidade(rs.getString("cidade"));
			t.setUf(rs.getString("uf"));
			t.setCep(rs.getInt("cep"));
			t.setTelefone(rs.getString("telefone"));
			t.setAtivo(rs.getInt("ativo"));
			
					listaTeatro.add(t);
				  
	            } 
			System.out.println("Lista de teatros advindo do banco e seus dados:" + listaTeatro);
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return listaTeatro;

	}


	public int buscarTeatroPorNome(String nomeTeatro) {
		Integer codigo = null;
		String sql ="select id_teatro from teatro where nome_teatro = ?";
			
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, nomeTeatro);
			rs = ps.executeQuery();			
			while(rs.next()) {
			codigo = rs.getInt("id_teatro");
			} 
			
			System.out.println("código do teatro" + nomeTeatro + ": " + codigo);
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return codigo;
	
	}


	
	
	
}
