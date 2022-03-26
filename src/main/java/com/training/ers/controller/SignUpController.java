package com.training.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.ers.dao.EmployeeLoginDAO;
import com.training.ers.dao.EmployeeLoginDAOImpl;
import com.training.ers.dao.LoginDAO;
import com.training.ers.dao.LoginDAOImpl;
import com.training.ers.model.EmployeeUser;
import com.training.ers.model.User;


/**
 * Servlet implementation class SignUpController
 */
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		

		// my code
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><body>");

		String username = request.getParameter("username");
		String passwords = request.getParameter("passwords");
		String gender = request.getParameter("gender");
		
		String notification[] =request.getParameterValues("notification");
		String qualification = request.getParameter("qualification");
		String finalNotification="";
		
		for (String temp:notification) {
			finalNotification += temp + ":";   // Email:SMS:Courier
		}
		
		
		EmployeeUser employeeuser=new EmployeeUser(-1, username, passwords, gender, finalNotification,qualification);
		
		// DB  // store these details
		EmployeeLoginDAO employeeloginDAO = new EmployeeLoginDAOImpl();
		
		
		boolean empResult= employeeloginDAO.isEmployeeExists(username);
		if(!empResult) {
			
			employeeloginDAO.employeeRegister(employeeuser);
			
			out.println("You have registed : " + username + " successfully.");
			//out.println("<h1>Your are registed successfully and passwords is : </h1> " );
			
			//out.println("His/Her passwords is: " + passwords);
			//out.println("<a href=login.html> Login </a>");
				
			//out.println("<a href= welcome.jsp> Welcome Managers </a> ");
			out.println("<a href= signUp.html> SignUp </a> ");
			
		}
		else { 		
				out.println("The employee username already existed. Please resgist another name.");
				out.println("<a href= signUp.html> SignUp </a> ");
				
				
		}	
		out.println("</body> </html>");
						
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		// my code
		
		
		
		
	}

}
