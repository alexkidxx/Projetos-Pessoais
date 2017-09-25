package com.MeuTeatroPortal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MeuTeatroPortal.Dao.TeatroDAO;
import com.MeuTeatroPortal.Dao.UsuarioDAO;
import com.MeuTeatroPortal.Entidades.Teatro;
import com.MeuTeatroPortal.Entidades.Usuario;

/**
 * Servlet implementation class CadastrarTeatroServlet
 */
@WebServlet("/CadastrarTeatroServlet")
public class CadastrarTeatroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarTeatroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Teatro t = new Teatro();
	TeatroDAO tdao = new TeatroDAO();
		
	
	t.setNomeTeatro(request.getParameter("nome"));
	t.setRazaoSocial(request.getParameter("razaoSocial"));
	t.setEndereco(request.getParameter("endereco"));
	t.setCnpj(request.getParameter("cnpj"));
	t.setCidade(request.getParameter("cidade"));
	t.setUf(request.getParameter("uf"));
	t.setCep(Integer.parseInt(request.getParameter("cep")));
	t.setTelefone(request.getParameter("telefone"));
	String statusTeatro = request.getParameter("ativo");
	
	
	
	
	if(statusTeatro.equals("ativo"))
		t.setAtivo(1);
	else
		t.setAtivo(0);
	
	
	tdao.cadastrar(t);
	

	}

}
