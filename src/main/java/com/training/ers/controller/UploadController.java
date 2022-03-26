package com.training.ers.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class Upload
 */
// @WebServlet("/UploadController")
public class UploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><body>");
		
		//String username = (String)session.getAttribute("username"); 
		String employeename= (String) request.getServletContext().getAttribute("employeename");
		
		String employpassword = (String) request.getServletContext().getAttribute("employeepassword");
		
		String savePath= this.getServletContext().getRealPath("/WEB-INF/upload");
		System.out.println(savePath);
		
		File file= new File(savePath);
		
		// check if the path  exists, 
		if(!file.exists() && !file.isDirectory()) {
			System.out.println(savePath + " The Diretory does not exist, need to create it ");
			
			// create the directory
			file.mkdirs();
		}
		
		// message info
		String message="";
		
			// 1. create a DiskFileItemFactory
			DiskFileItemFactory factory= new DiskFileItemFactory();
			
			// 2. create a ServletFileUpload
			ServletFileUpload sf = new ServletFileUpload(factory);
			
			// 3, check if this normal input , not file input
			
			//if(!ServletFileUpload.isMultipartContent(request)) {
			// =======================
			//	float reimburseHotel = request.getParameter("reimburseHotel");
			
			try {		
					List<FileItem> formData= sf.parseRequest(request);
				
					for(FileItem f1:formData) {
						
						if(f1.isFormField()) {
							System.out.println("# normal input: " + f1.getFieldName() + " : " + f1.getString());
				
						}else {
							System.out.println("# file upload input: " + f1.getFieldName());
					
							// 3. save file in /upload folder
							String path =request.getServletContext().getRealPath("/upload");
					
							System.out.println("the Directory of the uploaded file" + path);
					
							// filename
							String fileName= f1.getName();
					
							f1.write(new File(path, fileName));
						}
				}
						
			}catch(Exception e){
		
				e.printStackTrace();
			}
		
		
		}
		


}
