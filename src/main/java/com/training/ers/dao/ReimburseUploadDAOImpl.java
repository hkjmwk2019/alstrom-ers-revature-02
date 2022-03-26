package com.training.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.training.ers.model.EmployeeUser;
import com.training.ers.model.Reimbursement;
import com.training.pms.utility.DBConnection;

public class ReimburseUploadDAOImpl implements ReimburseUploadDAO {
	
	//private static org.apache.log4j.Logger logger= Logger.getAnonymousLogger(LoginDAOImpl.class);
		Connection con= DBConnection.getConnection();
		

	@Override
	public boolean registerReimburse(Reimbursement reimbursement) {
		// TODO Auto-generated method stub
		//Connection con=DBConnection.getConnection();
		
				//System.out.println("## Adding user :" + reimbursement);
				PreparedStatement statement = null;
				int rows = 0;
				try {
					statement = con.prepareStatement("insert into reimbursement values(default,?,?,?,?,?)");
					
					statement.setString(1, reimbursement.getEmployeename());
					statement.setInt(2, reimbursement.getReimburseHotel());
					statement.setInt(3, reimbursement.getReimburseAirplaneticket());
					statement.setInt(4, reimbursement.getReimburseRentCar());
					statement.setString(5, reimbursement.getStatus());

					rows = statement.executeUpdate();
					System.out.println(rows + "  Employee's reimburse application successfully ");
								
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (rows == 0)
					return false;
				else			
					return true;
	}

	@Override
	public List<Reimbursement> getReimburseByEmployeeName(String employeename) {
		//System.out.println("## Printing the reimbursements  ");
		
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		PreparedStatement stat;
		try {
			stat = con.prepareStatement("select reimburseId,reimburseHotel,reimburseAirplaneticket,reimburseRentCar,status  from reimbursement where employeename =?");;
			
			stat.setString(1, employeename);
			ResultSet res = stat.executeQuery();	
			
			while (res.next()) {
				Reimbursement reimbursement = new Reimbursement();
				
				reimbursement.setReimburseId(res.getInt(1));
				reimbursement.setEmployeename(employeename);
				
				reimbursement.setReimburseHotel(res.getInt(2));
				reimbursement.setReimburseAirplaneticket(res.getInt(3));  
				
				reimbursement.setReimburseRentCar(res.getInt(4));
				reimbursement.setStatus(res.getString(5));
				 
				reimbursements.add(reimbursement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
			
	}

	@Override
	public List<Reimbursement> getReimburseByStatus(String reimbursestatus) {
		
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();

		PreparedStatement stat;
		try {
			stat = con.prepareStatement("select reimburseId,employeename,reimburseHotel,reimburseAirplaneticket,reimburseRentCar from reimbursement where status =?");;
			
			stat.setString(1, reimbursestatus);
			ResultSet res = stat.executeQuery();	
			
			while (res.next()) {
				Reimbursement reimbursement = new Reimbursement();
				
				reimbursement.setReimburseId(res.getInt(1));
				reimbursement.setEmployeename(res.getString(2));
				
				reimbursement.setReimburseHotel(res.getInt(3));
				reimbursement.setReimburseAirplaneticket(res.getInt(4));  
				
				reimbursement.setReimburseRentCar(res.getInt(5));
				reimbursement.setStatus(reimbursestatus);
				 
				reimbursements.add(reimbursement);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
		
	}

	@Override
	public boolean approveReimburseById(int reimbursementId) {
		
		//System.out.println("## Printing the reimbursements  ");
		
		PreparedStatement stat = null;
		int rows=0;
		try {
			stat = con.prepareStatement("update reimbursement set status = ? where reimburseId =?");
			
			stat.setString(1, "approved");
			stat.setInt(2, reimbursementId);
			
			rows = stat.executeUpdate();
			System.out.println(rows + " The application got approved, infomation updated successfully");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			if(rows==0)
				return false;
			else
				return true;
		
	}

	@Override
	public boolean rejectReimburseById(int reimbursementId) {
		//System.out.println("## Printing the reimbursements  ");
		
		PreparedStatement stat = null;
		int rows=0;
		try {
			stat = con.prepareStatement("update reimbursement set status = ? where reimburseId =?");
			
			stat.setString(1, "rejected");
			stat.setInt(2, reimbursementId);
			
			rows = stat.executeUpdate();
			System.out.println(rows + " The application got rejected, infomation updated successfully");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			if(rows==0)
				return false;
			else
				return true;
	}
	
	
	

}
