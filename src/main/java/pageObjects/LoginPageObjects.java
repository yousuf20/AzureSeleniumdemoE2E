package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObjects {
	
	public WebDriver driver;
	
	public LoginPageObjects(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(css="#email")
	WebElement Username;
	
	public WebElement getuser() {
		return Username;
	}
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	
	public WebElement getpassword() {
		return Password;
	}
	
	@FindBy(id="submit1")
	WebElement Login;
	
	public WebElement loginbtn() {
		return Login;
	}
	
	@FindBy(linkText="Forgot your password?")
	WebElement forgotpassword;
	
	public ForgotpasswordPO forgotpassword() {
		forgotpassword.click();
		return new ForgotpasswordPO(driver);
		
	}
	
	@FindBy(xpath="//i[@class='icon-keyboard-arrow-down icon-after']")
	WebElement Logout;
	
	public WebElement logout() {
		return Logout;
	}
	
	@FindBy(xpath="//a[@id='m-global-toolbar__nav__utility-user-dd__logout']")
	WebElement logout1;
	
	public WebElement logoutbtn() {
		return logout1;
	}
	
	@FindBy(xpath="//span[contains(text(),'Broadband Plans')]")
	WebElement Name ;
	
	public WebElement getName() {
		return Name;
	}
	}

