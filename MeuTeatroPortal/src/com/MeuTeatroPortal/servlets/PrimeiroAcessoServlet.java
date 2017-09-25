package com.MeuTeatroPortal.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MeuTeatroPortal.Dao.UsuarioDAO;

/**
 * Servlet implementation class PrimeiroAcessoServelet
 */
@WebServlet("/PrimeiroAcessoServlet")
public class PrimeiroAcessoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public PrimeiroAcessoServlet() {
        super();
   
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailCriptado = request.getParameter("ativacao");
		String email;
		UsuarioDAO udao = new UsuarioDAO();
		email = udao.buscaIdPorNome(emailCriptado);
		System.out.println("o email para por na request é: " + email);
		System.out.println("o email emcriptado que foi enviado para o dao é: " + emailCriptado);
			request.setAttribute("email", email);
				
		  String proxUrl;
          proxUrl = "/primeiroAcesso.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(proxUrl);
          rd.forward(request, response);
		
			
		}
		
	}


