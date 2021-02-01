package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	
	public WebDriver driver;
	
	public HomePageObjects(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	@FindBy(xpath="//span[contains(text(),'Log in')]")
	private WebElement Login;
	
	public LoginPageObjects getlogin() {
		Login.click();
		return new LoginPageObjects(driver);
		
	}	
	@FindBy(xpath="//a[contains(@class,'m-global-toolbar__nav__menu__item--y2d__login')]")
	private WebElement mlogin;
	
	public WebElement mlogin() {
		return mlogin;
	}
	
	@FindBy(xpath="//li[@id='promo-product-category-tab-1']")
	private WebElement Deal;
	
	public WebElement getdeal() {
	return Deal;
	}
	
	@FindBy(xpath="//a[@class='icon-twitter']")
	private WebElement twitterlink;
	
	public WebElement twitter() {
		return twitterlink;
	}
	
}
