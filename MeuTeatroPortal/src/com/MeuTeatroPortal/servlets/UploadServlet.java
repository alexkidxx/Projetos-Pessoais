package com.MeuTeatroPortal.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String path = request.getServletContext().getRealPath("img") + File.separator;
	 
	 
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
			String contentType  = item.getContentType();
			if(!contentType.equals("image/png")){
				out.println("only png format image files supported");
				continue;
			}
			
			File uploadDir = new File(path);
			File file = File.createTempFile("img", ".png",uploadDir);
			item.write(file);
			
			out.println("File saved successfully");
		}
		
	}
		catch(FileUploadException e){
			out.println("upload fail");
		}
		catch(Exception ex){
			out.println("pau na porra toda, num mandou pra o d:");
		}
		
		
		
	}

}
