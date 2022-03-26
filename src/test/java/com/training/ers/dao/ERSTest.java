package com.training.ers.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.TestCase;

public class ERSTest extends TestCase {
	WebDriver driver;
	String browserName = "edge";
	@BeforeEach
	protected void setUp() throws Exception {
		if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else if(browserName.equals("chrome")) {
			
			WebDriverManager.edgedriver().setup();
			driver=new ChromeDriver();
		}
	}
	
	@Test
	@DisplayName("Testing login functionlity of ERS")
	public void testERSLoginFunctionlity() {
		driver.get("http://localhost:8081/alstrom-ers-revature/login.html");
		driver.manage().window().maximize();
		
		//XPATH locators
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("test0");
		driver.findElement(By.xpath("//*[@id=\"passwords\"]")).sendKeys("222222");
		
		driver.findElement(By.id("btnSubmit")).click();
		
		
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	

}
