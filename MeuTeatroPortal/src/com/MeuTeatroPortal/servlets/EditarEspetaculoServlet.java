package com.MeuTeatroPortal.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MeuTeatroPortal.Dao.EspetaculoDAO;
import com.MeuTeatroPortal.Entidades.Espetaculo;

/**
 * Servlet implementation class EditarEspetaculoServlet
 */
@WebServlet("/EditarEspetaculoServlet")
public class EditarEspetaculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarEspetaculoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("idEspetaculo");
	
		int idAntes = Integer.parseInt(id);  
		EspetaculoDAO edao= new EspetaculoDAO();
		Espetaculo es = new Espetaculo();
		
		
		es = edao.buscarEspetaculoPorId(idAntes);
	System.out.println("esse espetaculo parece vir sem id" + es);
		request.setAttribute("es", es);
		
	   String proxUrl;
       proxUrl = "/editarEspetaculo.jsp";
       RequestDispatcher rd = request.getRequestDispatcher(proxUrl);
       rd.forward(request, response);
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// img para resolver 
		int espetaculoId = Integer.parseInt(request.getParameter("idAntes"));
		
		Espetaculo antes,depois = new Espetaculo();
		EspetaculoDAO edao = new EspetaculoDAO();
		antes = edao.buscarEspetaculoPorId(espetaculoId);
	
		
		depois.setIdEspetaculo(espetaculoId);
		depois.setNomeEspetaculo(request.getParameter("nomed"));
		depois.setDescricao(request.getParameter("descricaod"));
		depois.setPreco(request.getParameter("precod"));
		depois.setCia(request.getParameter("ciad"));		
		depois.setClassificacaoIndicativa(Integer.parseInt(request.getParameter("classificacaod")));
		depois.setLink(request.getParameter("linkd"));
				
		String dataEvento = request.getParameter("dataEventod");
		
		if(dataEvento.contains("/")){
			depois.setDataEvento(ajustaData(dataEvento));
			
		}else{
				depois.setDataEvento(request.getParameter("dataEventod"));
		}
		depois.setHoraEvento(request.getParameter("horad"));
	
		
		
		if(!antes.equals(depois)){	
		edao.atualizarEspetaculo(depois);
		
		response.sendRedirect("home.jsp");//precisa ver quem é o logado para redirecionar certo
			
		}else{
			
			response.sendRedirect("home.jsp");//precisa ver quem é o logado para redirecionar certo
			
			
			System.out.println("não é igual manda para o dao para atualizar");
			
		}
		
		
		
		
		
		
		
		
	}

	private String ajustaData(String dataF) {
		//no banco é yy-mm-dd
		String diaFormatadoBanco;
		String ano=dataF.substring(dataF.length()-4);
		String dia= dataF.substring(0, 2);
		String mes= dataF.substring(3,5);

		diaFormatadoBanco = ano +"-"+ mes +"-"+ dia;
		return diaFormatadoBanco;
	}

	
	
	
	
	
}
