package com.MeuTeatroPortal.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MeuTeatroPortal.Dao.UsuarioDAO;
import com.MeuTeatroPortal.Entidades.Usuario;

/**
 * Servlet implementation class ResponderPerguntaSecretaServlet
 */
@WebServlet("/ResponderPerguntaSecretaServlet")
public class ResponderPerguntaSecretaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponderPerguntaSecretaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String respostaSecretaDoBanco =  (String) request.getSession().getAttribute("respostaSecretaDoBanco");
		String respostaSecretaDoUsuario = request.getParameter("respostaSecretaDoUser");
		String email = request.getParameter("email");
		
		System.out.println("resposta do banco: "+ respostaSecretaDoBanco);
		System.out.println("email: "  + email);
		System.out.println("resposta do user: "+respostaSecretaDoUsuario);
		
		
		if(respostaSecretaDoBanco.equals(respostaSecretaDoUsuario)){
			Usuario u = new Usuario();
			u.setEmail(email);
			UsuarioDAO udao = new UsuarioDAO();
			udao.prepararReset(udao.getId(u.getEmail()),u.getEmail());	
			udao.gerarEmailPrimeiroAcesso(u);
			
			String proxUrl;

	           proxUrl = "/index.jsp";
	           RequestDispatcher rd = request.getRequestDispatcher(proxUrl);
	           rd.forward(request, response);	
			
		}else {
			String proxUrl;

	           proxUrl = "/perguntaSecreta.jsp";
	           RequestDispatcher rd = request.getRequestDispatcher(proxUrl);
	           System.out.println("despacha para index senha errada");
	           rd.forward(request, response);	
			
		}
		}
		
		
		
		
}
