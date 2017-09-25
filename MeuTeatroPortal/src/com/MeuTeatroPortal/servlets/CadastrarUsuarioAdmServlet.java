package com.MeuTeatroPortal.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MeuTeatroPortal.Dao.UsuarioDAO;
import com.MeuTeatroPortal.Entidades.Usuario;

/**
 * Servlet implementation class CadastrarUsuarioAdmServlet
 */
@WebServlet("/CadastrarUsuarioAdmServlet")
public class CadastrarUsuarioAdmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarUsuarioAdmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	Integer teatroP = null;
	Usuario u = new Usuario();
	UsuarioDAO udao = new UsuarioDAO();
	u.setNome(request.getParameter("nome"));
	u.setEmail(request.getParameter("email"));
	u.setTeatroPertencente(Integer.parseInt(request.getParameter("teatro")));
	u.setPerguntaSecreta(request.getParameter("perguntaSecreta"));
	u.setRespostaSecreta(request.getParameter("respostaSecreta"));
	u.setNivelDeAcesso(Integer.parseInt(request.getParameter("nivelDeAcesso")));
	u.setTelefone(request.getParameter("telefone"));
	
	if(!existeNaBase(u, request, response)){
		udao.cadastrar(u);
	}else{
		System.out.println("Este email já está cadastrado na base de dados" + usuarioExistente(u, request)); //em sysout por enquanto
		
	}
	
	
	
	}

	private Usuario usuarioExistente(Usuario u,HttpServletRequest request) {
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		lista = (ArrayList<Usuario>) request.getSession().getAttribute("listaUsuario");
		
		
		for(Usuario a: lista){
		if(a.getEmail().equals(u.getEmail()))
			return a;
		}
		return null;
	}


	private boolean existeNaBase(Usuario u,HttpServletRequest request, HttpServletResponse response){
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		ArrayList<String> listaEmail = new ArrayList<String>();
		lista = (ArrayList<Usuario>) request.getSession().getAttribute("listaUsuario");
		
		
		for(Usuario a: lista){
		listaEmail.add(a.getEmail());
		}
		
		if(listaEmail.contains(u.getEmail()))
			return true;
		return false;
			
		}
		
		
	}
	
	
	

