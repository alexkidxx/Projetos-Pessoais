package com.MeuTeatroPortal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MeuTeatroPortal.Dao.EspetaculoDAO;

/**
 * Servlet implementation class publicarEspetaculoServlet
 */
@WebServlet("/publicarEspetaculoServlet")
public class publicarEspetaculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
      public publicarEspetaculoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idEspetaculo");
		
		
		EspetaculoDAO edao = new EspetaculoDAO();
		edao.publicar(id);
		
		
		
		
	}

}
