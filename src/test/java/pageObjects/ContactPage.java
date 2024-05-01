package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.TestUtil;


public class ContactPage extends BasePage {
	
	public ContactPage(WebDriver driver)
	{
		super(driver);
	}
	
	TestUtil test = new TestUtil();
    
	By contacts = By.xpath("//i[@class='users icon']");
	
    
	By addContacts = By.xpath("//div[@class='menu-item-wrapper'][3]//button");
	
    
	By firstName = By.xpath("//input[@name='first_name']") ;
	

	By lastName = By.xpath("//input[@name='last_name']") ;
	

	By company = By.xpath("//div[@name='company']") ;	

	By save = By.xpath("//button[@class='ui linkedin button']") ;
	
	
	public void addContacts(String fname,String lname) throws Exception
	{   
		test.clickElementWhenReady(contacts, 10);
		test.clickElementWhenReady(addContacts, 10);
		test.enterTextInElementWhenReady(firstName, 10, fname);
		test.enterTextInElementWhenReady(lastName, 10, lname);
		test.clickElementWhenReady(save, 10);

	}
	

}
