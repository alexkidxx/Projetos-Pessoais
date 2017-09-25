package com.MeuTeatroPortal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MeuTeatroPortal.Dao.EspetaculoDAO;

/**
 * Servlet implementation class ApagarEspetaculoServlet
 */
@WebServlet("/ApagarEspetaculoServlet")
public class ApagarEspetaculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ApagarEspetaculoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idEspetaculo"));
		
		EspetaculoDAO edao = new EspetaculoDAO();
		edao.deletarEspetaculo(id);
		 
		
	}

}
