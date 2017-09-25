package com.MeuTeatroPortal.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.MeuTeatroPortal.Dao.EspetaculoDAO;
import com.MeuTeatroPortal.Entidades.Espetaculo;
import com.MeuTeatroPortal.Entidades.Usuario;


@WebServlet("/CadastrarEspetaculoServlet")
public class CadastrarEspetaculoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletContext().getRealPath("img") + File.separator;
		
		Espetaculo e = new Espetaculo();
		EspetaculoDAO eDao = new EspetaculoDAO();
		HashMap<String,String> hm = new HashMap<String,String>();
		
		String imgName = null;
		
	
		PrintWriter out = response.getWriter();
	
		if(!ServletFileUpload.isMultipartContent(request)){
		
			out.println("Nothing to upload!");
			
			return;
		}
	
		FileItemFactory itemFactory = new DiskFileItemFactory();
	
		ServletFileUpload up = new ServletFileUpload(itemFactory);
	
		try{
			
			List<FileItem> itens = up.parseRequest(request);
			
			for(FileItem item: itens){
			
				
				 if (item.isFormField()) {
				
					 
					 hm.put(item.getFieldName(), item.getString());
				
				 }else{
				String contentType  = item.getContentType();
				
			
			
				if(!contentType.equals("image/png")){
				
					out.println("only png format image files supported");
			
					continue;
				}
				File uploadDir = new File(path);
			
				File file = File.createTempFile("img", ".png",uploadDir);
			
				item.write(file);
			
				imgName = file.getName();
				
				
				out.println("File saved successfully");
			
			}
			
		}}
			
			catch(Exception ex){
				out.println("pau na porra toda, num mandou pra o d:");
			}

		e.setNomeEspetaculo(hm.get("nome"));
		e.setDescricao(hm.get("descricao"));
		Usuario u = (Usuario) request.getSession().getAttribute("usuario");
		e.setIdTeatro(u.getTeatroPertencente());
		e.setIdUsuario(u.getId());
		e.setPreco(hm.get("preco"));
		e.setDataEvento(ajustaData(hm.get("dataEvento")));
		e.setHoraEvento(hm.get("hora"));
		e.setCia(hm.get("cia"));
		e.setClassificacaoIndicativa(Integer.parseInt(hm.get("classificacao")));
		e.setLink(hm.get("link"));
		e.setImagemId(imgName);
		e.setStatus("novo");
		
		
		System.out.println("horaEvento: " + e.getHoraEvento() + "dataEvento: " + e.getDataEvento());
		System.out.println("horaEventodo HM"+hm.get("hora")+"dataEventodo HM" +hm.get("dataEvento"));
		System.out.println("data formatada pronta para ir para o banc: "+ ajustaData(hm.get("dataEvento")));
		System.out.println("esse é o espetaculo que vai para o banco" + e);
		//ajustar o formado data e o formato hora que o banco vai receber e descobrir o nome do png que vai para pasta do servidor
		//aproveitar para fazer isso tbm, colocar numa pasta dentro do projeto com o path relativo
	
		
		
		
	eDao.cadastrar(e);
		
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
