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

import com.training.ers.dao.EmployeeLoginDAO;
import com.training.ers.dao.EmployeeLoginDAOImpl;

/**
 * Servlet implementation class EmployeeSignInController02
 */
public class EmployeeSignInController02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger log = Logger.getLogger(EmployeeSignInController02.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeSignInController02() {
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
						
				String employeename= request.getParameter("username");
				String pwd = request.getParameter("passwords");	
				
				// set sesssion Attribute , name it username 
				HttpSession session = request.getSession();
				session.setAttribute("employeename", employeename);
				session.setAttribute("employeepasswords", pwd);
				
				//forward username, to UploadController
				request.getServletContext().setAttribute("employeename", employeename);
				
				
				
				EmployeeLoginDAO employeeloginDAO= new EmployeeLoginDAOImpl();	
				boolean result = employeeloginDAO.employeeValidate(employeename, pwd);
						
				if(result) {
					
					//session.setAttribute("message", loginDAO);
					session.setAttribute("message", "valid User");
					out.println("<h1> Welcome Employee : " + employeename +"</h1>" );
					
					//out.println(uname);
					//out.println("<h1> Please go to your home page</h1>" );
					//out.println("<a href=welcome.html>welcome page </a>");
					RequestDispatcher dispatcher= request.getRequestDispatcher("welcome_employee.jsp");
					dispatcher.include(request, response);			
				}else { 		
					out.println("Your username/passwords is incorrect.");
					out.println("<a href= employeelogin.html> Login </a>");
				}					
				out.println("</body> </html>");
			}
			

}
