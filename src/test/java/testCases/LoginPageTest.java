package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseClass;

public class LoginPageTest extends BaseClass {
	

	@Test(priority=2,enabled=false)
	public void LoginPageTitleTest() throws InterruptedException
	{  try {
		logger.info("**** starting test case Login Page Title Test  *****");
		LoginPage loginPage = new LoginPage(driver);
		String title = loginPage.validateLoginPageTitle();
		logger.info("Title of the page is: "+title);
		Assert.assertEquals(title, "STORE");
		logger.info("Expected and Actual Title Matched correctly");
	}
	catch(Exception e)
	{
		logger.error("test failed..");
		Assert.fail("An exception occurred: " + e.getMessage());
	}
	logger.info("**** Finished LoginPageTitleTest  *****");
	logger.info("application logs Finished for Login page......");
	}
	
	@Test(priority=1)
	public void loginTest() throws InterruptedException
	{      
		logger.info("application logs started for Login page......");
		logger.info("**** starting test case Login test  *****");
		try {
		LoginPage loginPage = new LoginPage(driver);
		logger.info("Clicked on login button");
		loginPage.login(p.getProperty("username"), p.getProperty("password"));
		logger.info("Entered username and password and clicked sign in");
		Assert.assertEquals(driver.findElement(By.id("logout2")).getText(),"Log out");
		}
		catch(Exception e)
		{
			logger.error("test failed..");
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		logger.info("**** Finished loginTest  *****");

	}
	
	@Test(priority=3,enabled=false)
	public void logOutTest() 
	{      
		logger.info("application logs started for Login page......");
		logger.info("**** starting test case Logout test  *****");
		try {
		LoginPage loginPage = new LoginPage(driver);
		logger.info("Clicked on logout button");
		loginPage.logout(p.getProperty("username"), p.getProperty("password"));
		logger.info("Asserting logIn text visible or not");
		Assert.assertEquals(driver.findElement(By.id("login2")).getText(),"Log i");
		}
		catch(Exception e)
		{
			logger.error("test failed..");
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		logger.info("**** Finished logOutTest  *****");

	}
	

}
