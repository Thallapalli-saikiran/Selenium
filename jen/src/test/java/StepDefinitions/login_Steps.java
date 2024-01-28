package StepDefinitions;

import org.openqa.selenium.By;

import PageObjects.Login_Page_Objects;
import common.PublicApp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class login_Steps extends PublicApp{
	
	
		private PublicApp base;
			
			public login_Steps(PublicApp base)
			{
				this.base= base;
			}
			
			Login_Page_Objects Lpage;

			
	
	@Given("user enter the bank url in browser")
	public void user_enter_the_bank_url_in_browser() {
	   //Lpage = new Login_Page_Objects(base.driver);
	   base.driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
	}
	@Given("given valid username and password")
	public void given_valid_username_and_password() {
		base.driver.findElement(By.xpath("//input[@name='username']")).sendKeys("saikiran");
		base.driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Saikiran@123");
	}
	@Then("clicks on login button")
	public void clicks_on_login_button() {
	   base.driver.findElement(By.xpath("//input[@value='Log In']")).click();
	}



}
