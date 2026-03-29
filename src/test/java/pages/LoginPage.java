package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitUtils;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
//	constructor why? because driver is created in BaseClass. we pass that driver to the page class
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
//   locators
By username =	By.name("username");
By password= By.name("password");
By loginbtn= By.xpath("//button[@type='submit']");
By erromsg= By.xpath("//p[contains(@class,'alert-content-text')]");

//Methods

public void login (String user,String pass) {
//	wait.until(ExpectedConditions.visibilityOfElementLocated(username));
//	wait.until(ExpectedConditions.presenceOfElementLocated(username));
	WaitUtils wu = new WaitUtils(driver);
	wu.waitForVisibility(username).sendKeys(user);
	wu.waitForVisibility(password).sendKeys(pass);
	wu.waitForVisibility(loginbtn).click();

	
}

//public void invalidLogin(String user ,String pass) {
//	wait.until(ExpectedConditions.presenceOfElementLocated(username));
//	driver.findElement(username).sendKeys(user);
//driver.findElement(password).sendKeys(pass);
//driver.findElement(loginbtn).click();
//System.out.println(driver.getCurrentUrl());
	
	
//}
public String getErrorMessage() {
	wait.until(ExpectedConditions.visibilityOfElementLocated(erromsg));
	return driver.findElement(erromsg).getText();
	
}

//public void enterPassword(String pass) {
//	wait.until(ExpectedConditions.visibilityOfElementLocated(password));
//	driver.findElement(password).sendKeys(pass);

//}
//public void clickLogin() {
//	wait.until(ExpectedConditions.visibilityOfElementLocated(loginbtn));
//	driver.findElement(loginbtn).click();
//}
}
