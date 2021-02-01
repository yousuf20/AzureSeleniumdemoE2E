package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotpasswordPO {
	
	public WebDriver driver;
	
	public ForgotpasswordPO(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath="//input[@id='email']")
	WebElement Email;
	
	public WebElement getEmail() {
		return Email;
	}
	
	@FindBy(xpath="//input[@name='/atg/userprofiling/ProfileFormHandler.forgotPassword']")
	WebElement resetpassword;
	
	public WebElement resetPassbtn() {
		return resetpassword;
	}
	
	
	
	
	
		}

