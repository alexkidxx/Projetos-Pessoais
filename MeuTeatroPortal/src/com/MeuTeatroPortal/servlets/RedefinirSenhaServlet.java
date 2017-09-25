package com.MeuTeatroPortal.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MeuTeatroPortal.Dao.AutenticadorDAO;
import com.MeuTeatroPortal.Entidades.Usuario;

/**
 * Servlet implementation class RedefinirSenhaServlet
 */
@WebServlet("/RedefinirSenhaServlet")
public class RedefinirSenhaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RedefinirSenhaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String perguntaSecreta;
		Usuario u = new Usuario();
		String notUser = "Email não encontrado.";
		
	AutenticadorDAO aut = new AutenticadorDAO();
	u = aut.getPerguntaSecreta(email);
	
	if(u.getPerguntaSecreta() != null){
			
		request.setAttribute("email", email);   
		request.setAttribute("perguntaSecreta",u.getPerguntaSecreta());
		//request.setAttribute("respostaSecretaDoBanco", u.getRespostaSecreta());
		request.getSession().setAttribute("respostaSecretaDoBanco", u.getRespostaSecreta());
	
	}else{
		
		request.setAttribute("perguntaSecreta", notUser);
		//só renderiza o formulário de envio da respostaSecreta no  jsp de perguntaSecreta se não for notUser
	}
	String proxUrl;
	


           proxUrl = "/perguntaSecreta.jsp";
           RequestDispatcher rd = request.getRequestDispatcher(proxUrl);
           System.out.println("despacha para index senha errada");
           rd.forward(request, response);	
	
	}

	
	
		
		
		
	}
	
	

