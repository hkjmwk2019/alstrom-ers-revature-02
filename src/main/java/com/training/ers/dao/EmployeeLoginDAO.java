package com.training.ers.dao;

import java.util.List;

import com.training.ers.model.EmployeeUser;
import com.training.ers.model.User;



public interface EmployeeLoginDAO {
	
	public boolean employeeRegister(EmployeeUser user);
	public boolean employeeValidate(String username, String passwords);
	
	public List<EmployeeUser> getEmployeeUsers();
	public List<EmployeeUser> getUsersByEmployeeUserName(String username);
	
	public boolean isEmployeeExists(String employeeusername);
	public boolean updateEmployeePassword(EmployeeUser employeeuser);
	public boolean changeEmployeePassword(String username, String passwords);

 	
}
