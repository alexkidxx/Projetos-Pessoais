package com.MeuTeatroPortal.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MeuTeatroPortal.Dao.UsuarioDAO;
import com.MeuTeatroPortal.Entidades.Usuario;


@WebServlet("/EditarDadosPessoaisServlet")
public class EditarDadosPessoaisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditarDadosPessoaisServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = new Usuario();
		UsuarioDAO udao = new UsuarioDAO();
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		u= (Usuario) request.getSession().getAttribute("usuarioLogado");
		
		if(!nome.equals(u.getNome())||!telefone.equals(u.getTelefone())){
			
			udao.atualizarDadoDoUsuario(nome,telefone,u.getId());
			//sobrescrever o sendRedirect para redirecionar conforme o usuario logado
		}else{
			
			response.sendRedirect("home.jsp");
		}
	}

}
