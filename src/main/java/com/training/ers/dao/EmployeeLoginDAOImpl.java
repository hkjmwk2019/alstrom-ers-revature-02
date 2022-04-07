package com.training.ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;


import com.training.ers.model.EmployeeUser;
import com.training.ers.model.User;
//import com.training.pms.model.Login;
//
import com.training.pms.utility.DBConnection;

public class EmployeeLoginDAOImpl implements EmployeeLoginDAO {
	
	private static Logger log= Logger.getLogger(EmployeeLoginDAOImpl.class.getName());
	
	
	Connection con= DBConnection.getConnection();
	
	@Override
	public boolean employeeRegister(EmployeeUser user) {
		
		//Connection con=DBConnection.getConnection();
		
		//System.out.println("## Adding user :" + user);
		PreparedStatement statement = null;
		int rows = 0;
		try {
			statement = con.prepareStatement("insert into employeeusers values(default,?,?,?,?,?)");
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPasswords());
			statement.setString(3, user.getGender());
			statement.setString(4, user.getNotifications());
			statement.setString(5, user.getQualification());

			rows = statement.executeUpdate();
			System.out.println(rows + "  employee user resgister successfully ");
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (rows == 0)
			return false;
		else	
		{   // System.out.println(rows + "  employee user resgister successfully ");
			return true;
		}
		
	}
	

	@Override
	public boolean employeeValidate(String username, String passwords) {
		
		//Connection con = DBConnection.getConnection();
		boolean userValid = false;
		PreparedStatement stat;
		try {
			stat = con.prepareStatement("select * from employeeusers where username = ? and passwords = ? ");
			stat.setString(1, username);
			stat.setString(2, passwords);
			
			ResultSet res = stat.executeQuery();	
			userValid = res.next();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// if can find the user and matched password, then userValid is true, otherwise false
		return userValid;
	}


	@Override
	public List<EmployeeUser> getEmployeeUsers() {
		
		//System.out.println("## Printing all employee users  ");
		
		List<EmployeeUser> employeeusers = new ArrayList<EmployeeUser>();

		Statement stat;
		try {
			stat = con.createStatement();
			ResultSet res = stat.executeQuery("select * from employeeusers");
			while (res.next()) {
				EmployeeUser employeeuser = new EmployeeUser();
				employeeuser.setUserId(res.getInt(1));
				employeeuser.setUsername(res.getString(2)); 
				
				employeeuser.setPasswords(res.getString(3));   
				employeeuser.setGender(res.getString(4));    
				employeeuser.setNotifications(res.getString(5));
				employeeuser.setQualification(res.getString(6)); 
				employeeusers.add(employeeuser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	    // sort users by userId
		// -- inner class
		// use case: i have to print the product details in descending
		//Collections.sort(employeeusers);
		Collections.sort(employeeusers, new Comparator<EmployeeUser>() {
			
			public int compare(EmployeeUser o1,EmployeeUser o2) {
				if(o1.getUserId()> o2.getUserId())
					return 1;
				else if (o1.getUserId() < o2.getUserId())
					return -1;
				else 
					return 0;
				
			}
		});
			
		
		return employeeusers;
	}


	@Override
	public List<EmployeeUser> getUsersByEmployeeUserName(String username) {
		
		//System.out.println("## Printing search employee users  ");
		List<EmployeeUser> employeeusers = new ArrayList<EmployeeUser>();
		
		PreparedStatement stat;
		
		try {
			
			stat = con.prepareStatement("select * from employeeusers where username = ? ;");
			
			stat.setString(1, username);
			ResultSet res = stat.executeQuery();	
			
			while (res.next()) {
				
				EmployeeUser employeeuser = new EmployeeUser();
				employeeuser.setUserId(res.getInt(1));
				employeeuser.setUsername(res.getString(2));
				
				employeeuser.setPasswords(res.getString(3));  
				employeeuser.setGender(res.getString(4));
				employeeuser.setNotifications(res.getString(5));
				employeeuser.setQualification(res.getString(6));
				
				employeeusers.add(employeeuser);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			
		
		return employeeusers;
	}


	@Override
	public boolean isEmployeeExists(String employeeusername) {
		// TODO Auto-generated method stub
		boolean employeeExists = false;
		PreparedStatement stat;
		try {
			stat = con.prepareStatement("select * from employeeusers where username = ? ");
			stat.setString(1, employeeusername);

			ResultSet res = stat.executeQuery();
			employeeExists =res.next();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeExists;
	}


	@Override
	public boolean updateEmployeePassword(EmployeeUser employeeuser) {
		// TODO Auto-generated method stub
		//System.out.println("## Change employee passwords :" + employeeuser);
		PreparedStatement statement = null;
		int rows=0;
		try {
			statement = con.prepareStatement
					("update employeeusers set passwords = ? where username = ?");
			
			
			statement.setString(2, employeeuser.getUsername());
							
			statement.setString(1, employeeuser.getPasswords());
		
			rows = statement.executeUpdate();
			System.out.println(rows + " updated passwords successfully");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rows==0)
			return false;
		else
			return true;
		
	}


	@Override
	public boolean changeEmployeePassword(String username, String passwords) {
		
		//System.out.println("## Change employee passwords :" + username);
		int rows=0;
		PreparedStatement stat=null;
		try {
			stat = con.prepareStatement
					("update employeeusers set passwords = ? where username = ?");
					
			stat.setString(1, passwords);
			stat.setString(2, username);
			
			
			rows = stat.executeUpdate();
			System.out.println(rows + " updated passwords successfully");

			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// if can find the user and matched password, then userValid is true, otherwise false
		if(rows==0)
			return false;
		else
			return true;
		
		
		
	}


	

	
}