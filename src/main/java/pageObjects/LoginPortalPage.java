package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPortalPage {
	
	public WebDriver driver;
	
	public LoginPortalPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
		
	@FindBy(xpath="//h2[contains(text(),'Syed Yousufuddin')]")
	private WebElement Verifyname;
	
	public WebElement verifyname() {
		return Verifyname;
	}
	
	

	
}
