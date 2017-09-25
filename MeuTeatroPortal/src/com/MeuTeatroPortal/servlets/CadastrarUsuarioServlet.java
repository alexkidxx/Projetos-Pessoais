package com.MeuTeatroPortal.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MeuTeatroPortal.Dao.UsuarioDAO;
import com.MeuTeatroPortal.Entidades.Usuario;

/**
 * Servlet implementation class CadastrarUsuarioServlet
 */
@WebServlet("/CadastrarUsuarioServlet")
public class CadastrarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Usuario cadastrante = (Usuario) request.getSession().getAttribute("usuario");
		
		
		Usuario u = new Usuario();
		UsuarioDAO udao = new UsuarioDAO();
		u.setNome(request.getParameter("nome"));
		u.setEmail(request.getParameter("email"));		
		u.setTelefone(request.getParameter("telefone"));
		u.setTeatroPertencente(cadastrante.getTeatroPertencente());
		u.setNivelDeAcesso(2);
		
		
		udao.cadastrar(u);
		
		
		
	}


	

}
