package com.MeuTeatroPortal.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.MeuTeatroPortal.Dao.EspetaculoDAO;
import com.MeuTeatroPortal.Entidades.Espetaculo;

/**
 * Servlet implementation class VerTeatroServlet
 */
@WebServlet("/VerTeatroServlet")
public class VerTeatroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerTeatroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String idTeatro = request.getParameter("id");
		EspetaculoDAO ed = new EspetaculoDAO();
		ArrayList<Espetaculo> listaEspetaculo = new ArrayList<Espetaculo>();
		listaEspetaculo = ed.buscarEspetaculosPorTeatro(Integer.parseInt(idTeatro));
		 String proxUrl;
          proxUrl = "/homeKeyUser.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(proxUrl);
          rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
