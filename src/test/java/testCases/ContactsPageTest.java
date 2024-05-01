package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ContactPage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.TestUtil;

public class ContactsPageTest extends BaseClass {

	TestUtil testUtil;
	ContactPage contactPage;
	LoginPage loginPage;
	String sheetName = "contacts";
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=1, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String fname, String lname) throws Exception{
		logger.info("application logs started for Contact page......");
		logger.info("**** starting test case for Creating contact  *****");
		try {
		loginPage = new LoginPage(driver);
		logger.info("Clicked on login button");
		loginPage.login(p.getProperty("username"), p.getProperty("password"));
		logger.info("Entered username and password and clicked sign in");
		contactPage = new ContactPage(driver);
		logger.info("Clicked Add Contacts Button");
		contactPage.addContacts(fname, lname);
		logger.info("Contacts Added");
		}
		catch(Exception e)
		{
			logger.error("test failed..");
		}
		
	}
	

	
}
