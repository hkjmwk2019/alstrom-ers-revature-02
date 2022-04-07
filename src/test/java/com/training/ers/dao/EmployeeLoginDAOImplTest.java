package com.training.ers.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.training.ers.model.EmployeeUser;

class EmployeeLoginDAOImplTest {
	
	EmployeeLoginDAO dao;
	EmployeeUser employeeuser;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//dao =  new EmployeeLoginDAOImpl();
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		dao = null;
	}
	


	@BeforeEach
	void setUp() throws Exception {
		
		dao = new EmployeeLoginDAOImpl();
		employeeuser = new EmployeeUser();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@Order(value = 1)
	void testEmployeeRegister() {
		//private static EmployeeLoginDAO dao = new EmployeeLoginDAOImpl();;
		//private static EmployeeUser employeeuser1 = null;
		boolean result=false;
		
		employeeuser = new EmployeeUser(-1, "test00", "222222", "Female", "Email", "Graduate");
		//employeeuser2 = new EmployeeUser(-1, "test000", "222222", "Female", "Email", "Graduate");
		result = dao.employeeRegister(employeeuser);
		//boolean result2 = dao.employeeRegister(employeeuser2);
			
		assertTrue(result);
		
	}

	@Test
	@Order(value = 2)
	void testIsEmployeeExists() {
		//fail("Not yet implemented");
		//employeeuser = new EmployeeUser(-1, "test15", "222222", "Female", "Email", "Graduate");
		String uname= "test0";
		boolean result = dao.isEmployeeExists(uname);	
				
		assertTrue(result);
		
	}



}
