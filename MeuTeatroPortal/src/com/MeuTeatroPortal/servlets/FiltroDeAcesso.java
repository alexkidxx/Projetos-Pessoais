package com.MeuTeatroPortal.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MeuTeatroPortal.Entidades.Usuario;

@WebFilter("/*")
public class FiltroDeAcesso implements Filter {


    public FiltroDeAcesso() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpServletrequest = (HttpServletRequest) request;
		String url = httpServletrequest.getRequestURI();
		HttpSession sessao = httpServletrequest.getSession();
		Usuario u= null;
		
		
		
		
		if(url.lastIndexOf("index.jsp")>-1 ||url.lastIndexOf("LoginServlet")>-1 || url.lastIndexOf("AutenticadorDAO")>-1 || url.lastIndexOf("perguntaSecreta.jsp")>-1 || url.lastIndexOf("RedefinirSenhaServlet")>-1 ){

			chain.doFilter(request, response);
			
		}	else if(sessao.getAttribute("usuarioLogado")!=null){
			
			
			u = (Usuario) sessao.getAttribute("usuarioLogado");
			int nivelDeAcesso = u.getNivelDeAcesso();
			
		switch(nivelDeAcesso){
		
		case 1:
			//Paginas restritas para usuario keyUser
			if(url.lastIndexOf("CadastrarTeatroServlet")>-1 ||url.lastIndexOf("CadastrarUsuarioAdmServlet")>-1 ||url.lastIndexOf("cadastrarTeatro.jsp")>-1 || url.lastIndexOf("cadastrarUsuarioAdm.jsp")>-1 ||url.lastIndexOf("homeAdm.jsp")>-1  ||url.lastIndexOf("VerTeatroServlet")>-1 )	{
				((HttpServletResponse) response).sendRedirect("index.jsp");
			}else{
				chain.doFilter(request, response);
			}
			break;
					
		case 2:
			//Paginas restritas para usuario comum
			if(url.lastIndexOf("CadastrarTeatroServlet")>-1 || url.lastIndexOf("CadastrarUsuarioAdmServlet")>-1	||url.lastIndexOf("CadastrarUsuarioServlet")>-1 ||url.lastIndexOf("mudaStatusServlet")>-1 ||url.lastIndexOf("publicarEspetaculoServlet")>-1||url.lastIndexOf("cadastrarTeatro.jsp")>-1 ||url.lastIndexOf("cadastrarUsuario.jsp")>-1 ||url.lastIndexOf("cadastrarUsuarioAdm.jsp")>-1 ||url.lastIndexOf("homeAdm.jsp")>-1 ||url.lastIndexOf("homeKeyUser.jsp")>-1 ||url.lastIndexOf("CadastrarUsuarioServlet")>-1||url.lastIndexOf("VerTeatroServlet")>-1 ){
				((HttpServletResponse) response).sendRedirect("index.jsp");
			}else{
				chain.doFilter(request, response);
			}
				break;
			
			default:
				chain.doFilter(request, response);
				break;
			}
			
		}
			
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
