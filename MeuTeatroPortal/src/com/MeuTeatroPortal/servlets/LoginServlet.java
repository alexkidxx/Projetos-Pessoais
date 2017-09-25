package com.MeuTeatroPortal.servlets;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.MeuTeatroPortal.Dao.AutenticadorDAO;
import com.MeuTeatroPortal.Entidades.Usuario;



/**
 *
 * @author Alex-vostro	
 */



@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        AutenticadorDAO aut = new AutenticadorDAO();
       
        try {
        	
            Usuario u = aut.autenticar(email, senha);

           if(senhaErrada(u)){
        	   
        	   String proxUrl;

               proxUrl = "/index.jsp";
             RequestDispatcher rd = request.getRequestDispatcher(proxUrl);
              
               rd.forward(request, response);
           }
                 
           else if(isAtivo(u)){
      
        	HttpSession sessao = request.getSession();
        	sessao.setAttribute("usuarioLogado", u);
        	//sessao.setMaxInactiveInterval(3000);
            request.getSession().setAttribute("usuario", u);
          
            String proxUrl;

            proxUrl = "/HomeServlet";
          
            RequestDispatcher rd = request.getRequestDispatcher(proxUrl);
           
            System.out.println("dispachou para a página");
            rd.forward(request, response);
           
          
           }else{
        	   String proxUrl;

               proxUrl = "/UsuarioInativo.html";
             RequestDispatcher rd = request.getRequestDispatcher(proxUrl);
               System.out.println("despacha para usuario inativo");
               rd.forward(request, response);

           }
        } catch (Exception ex) {

            request.setAttribute("erro", ex.getMessage());
System.out.println("Deu pau na autenticação" + ex.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }

    }




	private boolean senhaErrada(Usuario u) {
		if(u.getId()<=0)
			return true;
		return false;
	}

	private boolean isAtivo(Usuario u) {
		if(u.isAtivo())
			return true;
		return false;
	}
	
	
	

}
