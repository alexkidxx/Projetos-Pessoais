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
import com.MeuTeatroPortal.Dao.TeatroDAO;
import com.MeuTeatroPortal.Dao.UsuarioDAO;
import com.MeuTeatroPortal.Entidades.Espetaculo;
import com.MeuTeatroPortal.Entidades.Teatro;
import com.MeuTeatroPortal.Entidades.Usuario;



/**
 *
 * @author Alex-vostro
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/HomeServlet"})
public class HomeServlet extends HttpServlet {

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    	
    	request.setCharacterEncoding("UTF-8");
    	System.out.println("Chegamos em doPost de HomeServlet");
    	
    	ArrayList<Espetaculo> listaEspetaculo = new ArrayList<Espetaculo>();
    	ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
    	ArrayList<Teatro> listaTeatro = new ArrayList<Teatro>();
    	EspetaculoDAO ed = new EspetaculoDAO();
    	UsuarioDAO ud = new UsuarioDAO();
    	TeatroDAO td = new TeatroDAO();
    	
    	listaUsuario = ud.todosUsuarios();
    	listaTeatro = td.todosTeatros();
    	
    	Usuario u = (Usuario) request.getSession().getAttribute("usuario");
    	
    	listaEspetaculo = ed.buscarEspetaculosPorTeatro(u.getTeatroPertencente());
    	request.getSession().setAttribute("listaEspetaculo", listaEspetaculo); 
    	request.getSession().setAttribute("listaUsuario", listaUsuario);
    	request.getSession().setAttribute("listaTeatro", listaTeatro);
    	 
    	String proxUrl = hubDeAcesso(u.getNivelDeAcesso());

     	 response.setContentType("text/html;charset=UTF-8");
         RequestDispatcher rd = request.getRequestDispatcher(proxUrl);
         rd = request.getRequestDispatcher(proxUrl);
         rd.forward(request, response);
    }

	private String hubDeAcesso(int nivelDeAcesso) {
		
		String s = null;
		if(nivelDeAcesso == 0){
			s="/homeAdm.jsp";
		}
			else if(nivelDeAcesso == 1){
				s="/homeKeyUser.jsp";
				
			}else s="/home.jsp";
			
		return s;	
		}
	}






















