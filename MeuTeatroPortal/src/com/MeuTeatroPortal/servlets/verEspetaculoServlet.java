package com.MeuTeatroPortal.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MeuTeatroPortal.Entidades.Espetaculo;

/**
 * Servlet implementation class verEspetaculoServlet
 */
@WebServlet("/verEspetaculoServlet")
public class verEspetaculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verEspetaculoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Espetaculo es = new Espetaculo();
			ArrayList<Espetaculo> list = new ArrayList<Espetaculo>();
			list= (ArrayList<Espetaculo>) request.getSession().getAttribute("listaEspetaculo");
			int id = Integer.parseInt(request.getParameter("id"));
			
			for(Espetaculo esp:list){
				if(esp.getIdEspetaculo()==id)
					request.setAttribute("es", esp);
			}
			
		   String proxUrl;

           proxUrl = "/verEspetaculo.jsp";
         RequestDispatcher rd = request.getRequestDispatcher(proxUrl);
           System.out.println("despacha para ver espetaculo detalhado");
           rd.forward(request, response);

	}	
		
}
