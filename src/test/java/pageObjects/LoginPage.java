package pageObjects;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.TestUtil;



public class LoginPage extends BasePage {
	
	
	// Initialize page objects
		public LoginPage(WebDriver driver)
		{
			super(driver);
		}
		
    TestUtil test = new TestUtil();
	//PageFactory OR
	
	By username = By.id("loginusername");
	
	By password = By.id("loginpassword");
	
	By Login = By.xpath("//button[contains(text(),'Log in')]");
	
	By PageLogin = By.xpath("//a[@id='login2']");
	
	By Logout = By.id("logout2");
	
	public String validateLoginPageTitle() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		return driver.getTitle();
	}

	
	public void login(String id,String pass)  
	{
		test.clickElementWhenReady(PageLogin, 10);
		test.enterTextInElementWhenReady(username, 10, id);
		test.enterTextInElementWhenReady(password, 10, pass);
		test.clickElementWhenReady(Login, 10);
		test.waitForElementTobeVisible(Logout, 10);
	}
	
	public void logout(String id , String pass)
	{
		login(id,pass);
		test.clickElementWhenReady(Logout, 10);
		test.waitForElementTobeVisible(PageLogin, 10);
	}
}
