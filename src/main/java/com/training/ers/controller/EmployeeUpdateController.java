package com.training.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.training.ers.dao.EmployeeLoginDAO;
import com.training.ers.dao.EmployeeLoginDAOImpl;
import com.training.ers.dao.LoginDAO;
import com.training.ers.dao.LoginDAOImpl;
import com.training.ers.model.User;


/**
 * Servlet implementation class SignUpController
 */
public class EmployeeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeUpdateController() {
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

		String passwords = request.getParameter("passwords");
		
		//String username = (String)session.getAttribute("username"); 
		String employeename= (String) request.getServletContext().getAttribute("employeename");
		
		// set sesssion Attribute , name it username 
		HttpSession session = request.getSession();
		session.setAttribute("employeename", employeename);
		session.setAttribute("employeepasswords", passwords);
			
		
		// DB  // store these details
		EmployeeLoginDAO employeeloginDAO = new EmployeeLoginDAOImpl();
		boolean result = employeeloginDAO.changeEmployeePassword(employeename, passwords);
		
	 
		session.setAttribute("message", "valid User");
		out.println("Welcome : " + employeename);
		out.println("<h1>Your new passwords is : </h1> " );
		out.println(passwords);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("welcome_employee.jsp");
		dispatcher.include(request, response);	
		
		
		
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
