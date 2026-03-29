package base;

 //import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	public  WebDriver driver; 
	public WebDriverWait wait;
	
	@BeforeMethod
	public void setup() {
		
	
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
//     	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //implicit wait
		driver.get("https://opensource-demo.orangehrmlive.com"); 

	}

	
		
	}
		

	
	
	


