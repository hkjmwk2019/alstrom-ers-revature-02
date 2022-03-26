package com.training.ers.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.training.ers.dao.EmployeeLoginDAO;
import com.training.ers.dao.EmployeeLoginDAOImpl;
import com.training.ers.dao.ReimburseUploadDAO;
import com.training.ers.dao.ReimburseUploadDAOImpl;
import com.training.ers.model.EmployeeUser;
import com.training.ers.model.Reimbursement;

/**
 * Servlet implementation class UploadController02
 */
public class UploadController02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadController02() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//doGet(request, response);
		int reimburseHotel, reimburseAirplaneticket,reimburseRentCar;
			reimburseHotel =0;
			reimburseAirplaneticket =0;
			reimburseRentCar =0;
		
				PrintWriter out= response.getWriter();
				response.setContentType("text/html");
				
				out.println("<html><body>");
				
				//String employeename = (String)session.getAttribute("employeename"); 
				String employeename= (String) request.getServletContext().getAttribute("employeename");
				
				//String employpassword = (String) request.getServletContext().getAttribute("employeepassword");
				
				String reimburseHotel_temp = request.getParameter("reimburseHotel");
				String reimburseAirplaneticket_temp= request.getParameter("reimburseAirplaneticket");
				String reimburseRentCar_temp = request.getParameter("reimburseRentCar");
				
				if ( (reimburseHotel_temp != null)  && (reimburseHotel_temp.length() != 0 )) 
					reimburseHotel = Integer.parseInt(reimburseHotel_temp);
					
				
				if (( reimburseAirplaneticket_temp != null )  &&  (reimburseAirplaneticket_temp.length() != 0)) 
					reimburseAirplaneticket=Integer.parseInt(reimburseAirplaneticket_temp);
				
				if ( reimburseRentCar_temp != null  && reimburseRentCar_temp.length() != 0) 
					reimburseRentCar =Integer.parseInt(reimburseRentCar_temp);
				
				
				//int reimburseairplaneticket=Integer.parseInt(request.getParameter("reimburseAirplaneticket"));
				//int reimburserentcar=Integer.parseInt(request.getParameter("reimburseRentCar"));
						 
				Reimbursement reimbursement=new Reimbursement(-1, employeename, reimburseHotel, reimburseAirplaneticket, reimburseRentCar,"pending");
				
				// DB  // store these details
				ReimburseUploadDAO reimbursementDAO = new ReimburseUploadDAOImpl();
				
				boolean empResult= reimbursementDAO.registerReimburse(reimbursement);
					
					
   				 out.println( employeename + " , your reimburse application submit successfully.");
					//out.println("<h1>Your are registed successfully and passwords is : </h1> " );
					
   				RequestDispatcher dispatcher= request.getRequestDispatcher("welcome_employee.jsp");
				dispatcher.include(request, response);	
				out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
