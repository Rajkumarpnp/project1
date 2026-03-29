package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class LoginTest extends BaseClass {
	
	@DataProvider(name = "loginData")
	public Object[] getData() {

	    return new Object[][]{

	        {"Admin", "admin123"},
	        {"wrong", "wrong"},
	        {"Admin", "wrong"}

	    };
	}
	
	
	

	@Test
	public void loginTest() {
		
		LoginPage ip = new LoginPage(driver);
//		ip.enterUsername("Admin");
//		ip.enterPassword("admin123");
	
		ip.login("Admin","admin123");
		
		
	
		String currentUrl = driver.getCurrentUrl();
		String ExpectedUrl="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		
		Assert.assertTrue(currentUrl.contains("dashboard")); 
		  }
	
	@Test
	public void invalidLoginTest() {
//		driver.get("https://opensource-demo.orangehrmlive.com/");
	LoginPage ip = new LoginPage(driver);
		ip.login("admakk","12345");
		String actualError = ip.getErrorMessage();
		String ExpectedError="Invalid credentials";
		
		Assert.assertEquals(actualError, ExpectedError);
		
	}
	}


