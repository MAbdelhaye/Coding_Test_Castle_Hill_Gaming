package StepDefinition;



import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.Base;
import Pages.LogIn_page;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class LogIn extends Base {
	private LogIn_page Lp;


@Given("I am on the Sauce Demo Login Page")
public void i_am_on_the_sauce_demo_login_page() {
	OpenBrowser("chrome");
	Lp= new LogIn_page(driver);
}
@When("I fill the account information for account StandardUser into the {string} field and the {string} field")
public void i_fill_the_account_information_for_account_standard_user_into_the_field_and_the_field(String usename, String password) {
   Lp.Enter_Username(usename);
   Lp.Enter_Password(password);
	
}
@When("I click the Login Button")
public void i_click_the_login_button() {
  Lp.Click_Login();  
}
@Then("I am redirected to the Sauce Demo Main Page")
public void i_am_redirected_to_the_sauce_demo_main_page() {
	
	Assert.assertEquals("Swag Labs",driver.getTitle());
	
}	

@Then("I verify the App Logo exists")
public void i_verify_the_app_logo_exists() {
   Assert.assertTrue(Lp.verify_the_App_Logo_exists());	
}

@When("I fill the account information for account LockedOutUser into the {string} field and the {string} field")
public void i_fill_the_account_information_for_account_locked_out_user_into_the_field_and_the_field(String username, String password) {
	 Lp.Enter_Username(username);
	 Lp.Enter_Password(password);
}

@Then("verify the Error Message contains the text {string}")
public void verify_the_error_message_contains_the_text(String error_text) {
	Assert.assertEquals(error_text,Lp.Get_error_Message());
  
	
}

@After
public void TscShot(Scenario sn) {
	
	if (sn.isFailed()) {
		TakesScreenshot TSC = (TakesScreenshot)driver;
		 byte[] screenshot = TSC.getScreenshotAs(OutputType.BYTES);
		 sn.attach(screenshot , "image/png", sn.getName());
	        
	}
	driver.quit();
	
	
}


}
