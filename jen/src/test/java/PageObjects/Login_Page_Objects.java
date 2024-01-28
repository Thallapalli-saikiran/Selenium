package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Page_Objects {
	
WebDriver driver=null;
	
	public Login_Page_Objects(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void Set_Username_inputBox (String Username) {
		driver.findElement(By.name("username")).sendKeys(Username);
	}
	
	public void Set_Password_inputBox (String Password) {
		driver.findElement(By.name("password")).sendKeys(Password);
		
	}
	
	public By Login_button = By.xpath("//input[@value='Log In']");
	
	
}
