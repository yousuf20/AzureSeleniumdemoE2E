package stepDefinations;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.Assert;

import Resources.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.LoginPortalPage;

@RunWith(Cucumber.class)
public class stepDefination extends base {

	@Given("^Initialize the driver with browser$")
	public void initialize_the_driver_with_browser() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	   
		driver=initializeDriver();
	}

	
	@Given("^Navigate to \"([^\"]*)\" Website$")
	public void navigate_to_website(String stringArg) {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(stringArg);
	}
	
	@Given("^Click Submit link to land on Login Page$")
	public void click_submit_link_to_land_on_login_page() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
        HomePageObjects hp = new HomePageObjects(driver);
		Thread.sleep(3000L);
		LoginPageObjects lp=hp.getlogin();
		hp.mlogin().click();
	}
	
	@When("^User enters (.+) and (.+) and Logs in$")
    public void user_enters_and_and_logs_in(String username, String password) {
		HomePageObjects hp = new HomePageObjects(driver);
		Assert.assertEquals(hp.twitter().getText(), "Twitter");
		LoginPageObjects lp=new LoginPageObjects(driver);
		lp.getuser().sendKeys(username);
		lp.getpassword().sendKeys(password);
		lp.loginbtn().click();
    }
	
	@Then("^Verify User logged in Successfully$")
	public void verify_user_logged_in_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    LoginPortalPage lpp=new LoginPortalPage(driver);
	    Assert.assertTrue(lpp.verifyname().isDisplayed());
	    
	}

	@And("^Close browsers$")
    public void close_browsers() throws Throwable {
		driver.close();
    }


}