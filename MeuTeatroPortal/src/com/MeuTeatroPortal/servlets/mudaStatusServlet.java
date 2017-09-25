package com.MeuTeatroPortal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MeuTeatroPortal.Dao.UsuarioDAO;

/**
 * Servlet implementation class mudaStatusServlet
 */
@WebServlet("/mudaStatusServlet")
public class mudaStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public mudaStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO udao = new UsuarioDAO();
		String status = request.getParameter("status");
		String id = request.getParameter("id");
		String verdade = "true";
		
		
		if(status.equals(verdade)){
		
			udao.inativar(id);
		}else{
			
			udao.ativar(id);
		}
			
		
		
	}

}
