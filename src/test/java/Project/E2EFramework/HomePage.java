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
import pageObjects.ForgotpasswordPO;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;

public class HomePage extends base{
	
	public WebDriver driver;
	HomePageObjects hp;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void preRequsites() throws IOException {
		driver=initializeDriver();
		
	}
	
	
	@Test(dataProvider="getData")
	public void Homepage(String Username, String Password, String text) throws IOException, InterruptedException {
		
		driver.get(prop.getProperty("url"));
		hp=new HomePageObjects(driver);
		
		Thread.sleep(3000L);
		LoginPageObjects lp=hp.getlogin();
		hp.mlogin().click();
		Assert.assertEquals(hp.twitter().getText(), "Twitter");
		
		//LoginPageObjects lp=new LoginPageObjects(driver);
		lp.getuser().sendKeys(Username);
		lp.getpassword().sendKeys(Password);
		lp.loginbtn().click();
		ForgotpasswordPO fp=lp.forgotpassword();
		fp.getEmail().sendKeys("xxx@xxx.com");
		fp.resetPassbtn().click();
		log.info("Log in successful");
		log.info(text);
		//lp.logout().click();
		//lp.logoutbtn().click();
		
	
	}
	
	@Test
	public void ValidateSocials() {
		
		Assert.assertEquals(hp.twitter().getText(), "twitter");
		
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data= new Object[2][3];
		data[0][0]="restricteduser@gmail.com";
		data[0][1]="Bissmillah1";
		data[0][2]="Restricted User";
		
		data[1][0]="nonrestricteduser@gmail.com";
		data[1][1]="Bissmillah1";
		data[1][2]="Non Restricted User";
		
		return data;
		
	}
	
	@AfterTest
	public void finalStep(){
		
		driver.close();
		
	}
}
