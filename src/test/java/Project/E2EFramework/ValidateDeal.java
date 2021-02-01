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

public class ValidateDeal extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void preRequsites() throws IOException {
		driver=initializeDriver();
		log.info("Browser initilized successfully");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Homepage");
	}
	
	@Test()
	public void Homepage() throws IOException, InterruptedException {
		
		HomePageObjects hp=new HomePageObjects(driver);
		Assert.assertTrue(hp.getdeal().isDisplayed());
		log.info("Hottest Pay Monthly Deals tab displayed successfully");
		
		

	}
	@AfterTest
	public void finalStep(){
		
		driver.close();
		
	}
	
	}
