package Project.E2EFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.base;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;

public class ValidateName extends base{
	
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void preRequsites() throws IOException {
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void ValidateName() throws IOException {
		
		
		LoginPageObjects lp=new LoginPageObjects(driver);
		
		Assert.assertEquals(lp.getName().getText(), "Prepaid Plans");
		log.error("Expected PrePaid Plans was not found");
		
		

	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data= new Object[1][3];
		data[0][0]="ysyed2006@gmail.com";
		data[0][1]="Bissmillah1";
		data[0][2]="Restricted User";
		
		/*data[1][0]="khsyed3@gmail.com";
		data[1][1]="Bissmillah2";
		data[1][2]="Non Restricted User";*/
		
		return data;
		
	}
	@AfterTest
	public void finalStep(){
		
		driver.close();
		
	}
}
