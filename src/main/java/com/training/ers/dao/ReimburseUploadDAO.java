package com.training.ers.dao;

import java.util.List;

import com.training.ers.model.Reimbursement;
import com.training.ers.model.User;

public interface ReimburseUploadDAO {
	
	public boolean registerReimburse(Reimbursement reimbursement);
	//public boolean validated(String username, String passwords);
	
	//public List<User> getUsers();
	public List<Reimbursement> getReimburseByEmployeeName(String employeename);
	
	public List<Reimbursement> getReimburseByStatus(String reimbursestatus);
	
	public boolean approveReimburseById(int reimbursementId);
	public boolean rejectReimburseById(int reimbursementId);
	
	//public boolean validateEmployee(String username, String passwords);
	//public boolean isEmployeeExists(int productId);

}
