package com.training.ers.dao;

import java.util.List;

import com.training.ers.model.User;


public interface LoginDAO {
	public boolean register(User user);
	public boolean validated(String username, String passwords);
	
	public List<User> getUsers();
	public List<User> getUsersByUserName(String username);
	
	//public boolean validateEmployee(String username, String passwords);
	//public boolean isEmployeeExists(int productId);
 	
}
