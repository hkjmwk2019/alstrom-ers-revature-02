package com.training.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.training.ers.dao.LoginDAO;
import com.training.ers.dao.LoginDAOImpl;

/**
 * Servlet implementation class SignInController
 */
public class SignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(SignInController.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInController() {
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
		
		// my code
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><body>");
				
		String uname= request.getParameter("username");
		String pwd = request.getParameter("passwords");	
		
		// set sesssion Attribute , name it username 
		HttpSession session = request.getSession();
		session.setAttribute("username", uname);
		
		LoginDAO loginDAO= new LoginDAOImpl();	
		boolean result = loginDAO.validated(uname, pwd);
				
		if(result) {
			
			//session.setAttribute("message", loginDAO);
			session.setAttribute("message", "valid User");
			out.println("<h1> Welcome : " + uname +"</h1>" );
			//out.println("<h1> Your password  : " + pwd +"</h1>" );
			//out.println(uname);
			//out.println("<h1> Please go to your home page</h1>" );
			//out.println("<a href=welcome.html>welcome page </a>");
			RequestDispatcher dispatcher= request.getRequestDispatcher("welcome.jsp");
			dispatcher.include(request, response);			
		}else { 		
			out.println("Your username/passwords is incorrect.");
			out.println("<a href= login02.html> Login </a>");
		}					
		out.println("</body> </html>");
	}
}
