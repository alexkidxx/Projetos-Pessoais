package com.MeuTeatroPortal.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.MeuTeatroPortal.Entidades.Espetaculo;

public class EspetaculoDAO {
	Connection c = new ConnectionFactory().getConnection();
	
	public void cadastrar(Espetaculo es) {
		
		String sql="insert into meuteatroportal.espetaculo(nome_espetaculo,descricao,id_teatro,id_usuario,preco,data_evento,hora,companhia_teatral,classificacao,link_externo,endereco_img,status_espetaculo)values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, es.getNomeEspetaculo());
			ps.setString(2, es.getDescricao());
			ps.setInt(3,es.getIdTeatro());
			ps.setInt(4, es.getIdUsuario());
			ps.setString(5, es.getPreco());
			ps.setString(6, es.getDataEvento());
			ps.setString(7, es.getHoraEvento());
			ps.setString(8, es.getCia());
			ps.setInt(9, es.getClassificacaoIndicativa());
			ps.setString(10, es.getLink());
			ps.setString(11, es.getImagemId());
			ps.setString(12, es.getStatus());
			
			ps.executeUpdate();
	

		} catch (SQLException e) {
			System.out.println("problemas para cadastrar espetáculo no banco");
			e.printStackTrace();
		}
		
	}

	public ArrayList<Espetaculo> buscarEspetaculosPorTeatro(int teatroPertencente) {
		
		String sql ="select id_espetaculo, nome_espetaculo, descricao, id_usuario, preco, data_evento, hora, companhia_teatral, classificacao, link_externo,endereco_img, status_espetaculo from espetaculo where id_teatro = ?";
		ArrayList<Espetaculo> listaEspetaculo = new ArrayList<Espetaculo>();
		
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, teatroPertencente);
			rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
				Espetaculo es = new Espetaculo();
					es.setIdEspetaculo(rs.getInt("id_espetaculo"));
					es.setNomeEspetaculo(rs.getString("nome_espetaculo"));
					es.setDescricao(rs.getString("descricao"));
					es.setIdTeatro(teatroPertencente);
					es.setIdUsuario(rs.getInt("id_usuario"));
					es.setPreco(rs.getString("preco"));
					es.setDataEvento(rs.getDate("data_evento").toString()); //formato de data no banco e string no objeto espetaculo
					es.setHoraEvento(rs.getTime("hora").toString());
					es.setCia(rs.getString("companhia_teatral"));
					es.setClassificacaoIndicativa(rs.getInt("classificacao"));
					es.setLink(rs.getString("link_externo"));
					es.setImagemId(rs.getString("endereco_img"));
					es.setStatus(rs.getString("status_espetaculo"));
					
					
					listaEspetaculo.add(es);
				  
	            } 
			System.out.println("Lista de espetaculos advindo do banco e seus dados:" + listaEspetaculo);
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return listaEspetaculo;

		
	}

	public Espetaculo buscarEspetaculoPorId(int espetaculoId) {
		
		String sql ="select nome_espetaculo, descricao, id_teatro, id_usuario, preco, data_evento, hora, companhia_teatral, classificacao, link_externo, endereco_img ,status_espetaculo from espetaculo where id_espetaculo = ?";
		
		Espetaculo es = new Espetaculo();
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, espetaculoId);
			rs = ps.executeQuery();
			
			//entrei no editar
			
			while(rs.next()) {
					es.setIdEspetaculo(espetaculoId);
					es.setNomeEspetaculo(rs.getString("nome_espetaculo"));
					es.setDescricao(rs.getString("descricao"));
					es.setIdUsuario(rs.getInt("id_usuario"));
					es.setPreco(rs.getString("preco"));
					es.setDataEvento(rs.getDate("data_evento").toString()); //formato de data no banco e string no objeto espetaculo
					es.setHoraEvento(rs.getTime("hora").toString());
					es.setCia(rs.getString("companhia_teatral"));
					es.setClassificacaoIndicativa(rs.getInt("classificacao"));
					es.setLink(rs.getString("link_externo"));
					es.setImagemId(rs.getString("endereco_img"));
					es.setStatus(rs.getString("status_espetaculo"));
					
					
					
				  
	            } 
			System.out.println("espetaculo advindo do banco e seus dados:" + es);
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
		return es;

	}

	public void publicar(String id) {
		
		int idd = Integer.parseInt(id);
		String sql="update espetaculo set status_espetaculo = ? where id_espetaculo = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, "publicado");
			ps.setInt(2, idd);
			ps.executeUpdate();
			} catch (SQLException e) {
			System.out.println("problemas para publicar espetaculo");
			e.printStackTrace();
		}

	}

	public void deletarEspetaculo(int id) {
		System.out.println("esse é o id que será deletado" + id);
	
		String sql="delete from espetaculo where id_espetaculo = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			} catch (SQLException e) {
			System.out.println("problemas para deletar espetaculo");
			e.printStackTrace();
		}
		
	}

	public void atualizarEspetaculo(Espetaculo depois) {
		//String sqls = "update espetaculo set nome_espetaculo,descricao,preco,data_evento,hora,companhia_teatral,classificacao,link_externo,status_espetaculo values(?,?,?,?,?,?,?,?,?) where id_espetaculo = ?";
		String sql = "update espetaculo set nome_espetaculo = ?, descricao = ?, preco = ?, data_evento = ?, hora = ?,companhia_teatral = ?, classificacao = ?,link_externo = ?,status_espetaculo = ? where id_espetaculo = ?";
		
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1, depois.getNomeEspetaculo());
			ps.setString(2, depois.getDescricao());
			ps.setString(3, depois.getPreco());
			ps.setString(4, depois.getDataEvento());
			ps.setString(5, depois.getHoraEvento());
			ps.setString(6, depois.getCia());
			ps.setInt(7, depois.getClassificacaoIndicativa());
			ps.setString(8, depois.getLink());
			ps.setString(9,"editado");
			ps.setInt(10, depois.getIdEspetaculo());
		
			System.out.println("a quere de edição: "+sql);
			System.out.println("esse é o depois: "+ depois);
			
			
			ps.executeUpdate();
			} catch (SQLException e) {
			System.out.println("problemas para editar espetaculo");
			e.printStackTrace();
		}

		
		
		
		
		
	}


	
	}

