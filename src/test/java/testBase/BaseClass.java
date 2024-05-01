package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j


public class BaseClass {

	static public WebDriver driver;
	//public WebDriver driver;// parallel testing
	public Logger logger;
	public Properties p;
	
	
	@BeforeMethod
	
	public void setup() throws IOException
	
	{
		//loading properties file
		 FileReader file=new FileReader(".//src//test//resources//config.properties");
		 p=new Properties();
		 p.load(file);
		
		
		//loading log4j 
		logger=LogManager.getLogger(this.getClass());//Log4j
				
				
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			    ChromeOptions options = new ChromeOptions();
			    options.addArguments("--incognito");
	            driver = new ChromeDriver(options);
		
		}
		
		
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		

		driver.get(p.getProperty("appURL"));
		//Set<Cookie> cookies = driver.manage().getCookies();
		//System.out.println(cookies);
//		for (Cookie cok :cookies)
//		{
//			driver.manage().addCookie(new Cookie(cok.getName(),cok.getValue()));
//		}
		//driver.manage().addCookie(new Cookie("_ga_FN5FHVSJC6","GS1.1.1714481652.1.0.1714481652.60.0.1660723518"));
		//driver.manage().addCookie(cookies[1])
//		System.out.println("i am here");
//		driver.switchTo().frame("__tcfapiLocator");
//		System.out.println("entered frame");
//		driver.findElement(By.xpath("//button[@id='cf_consent-buttons__accept-all']")).click();
//		System.out.println("entered");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		logger.info("Page Opened");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		logger.info("Page Closed");
	}
	

	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		
		return (str+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	
	
}
