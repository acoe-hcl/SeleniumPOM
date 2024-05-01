package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BaseClass;

public class TestUtil extends BaseClass {
	

//	public static long PAGE_LOAD_TIMEOUT = 20;
//	public static long IMPLICIT_WAIT = 20;
	
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\UTKARSH\\eclipse-workspace\\opencart-master\\testData\\TestData.xlsx";
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;


	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			//book = WorkbookFactory.create(file);
			book = new XSSFWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	
	public void clickElementWhenReady(By ele, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
	}
	
	
	public void enterTextInElementWhenReady(By ele, int timeOut,String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	    wait.until(ExpectedConditions.elementToBeClickable(ele)).sendKeys(text);

	}
	public String doGetTitle(String title, int timeOut) {
		if (waitForTitleToBe(title, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}
	
	public boolean waitForTitleToBe(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleIs(title));
	}
	
	public WebElement waitForElementTobeVisible(By ele,int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}

}
