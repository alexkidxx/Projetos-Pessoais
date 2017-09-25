package com.MeuTeatroPortal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MeuTeatroPortal.Dao.UsuarioDAO;

import util.Cifrador;

/**
 * Servlet implementation class SetaSenhaServlet
 */
@WebServlet("/SetaSenhaServlet")
public class SetaSenhaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
      public SetaSenhaServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String senha = Cifrador.criptografar(request.getParameter("senha"));
		String pergunta = request.getParameter("perguntaSecreta");
		String resposta = request.getParameter("respostaSecreta");
		String email = request.getParameter("email");
		UsuarioDAO udao = new UsuarioDAO();
		System.out.println("o email tem que existir: "+ email);
		Integer id=udao.getId(email);
		System.out.println("id que retornou: "+ id);
		udao.setaSenha(senha,pergunta,resposta,id);
		
		
		
	}

}
