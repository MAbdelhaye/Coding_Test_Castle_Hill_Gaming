package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Base.Base;

public class LogIn_page extends Base {

    // Elements Locators
     private By username_Elm = By.id("user-name");
     private By password_Elm = By.id("password");
     private By loginButton_Elm = By.id("login-button");
     private By logo_Elm=By.xpath("//div[@class='app_logo']");
     private By errorMessage_Elm = By.xpath("//h3[@data-test='error']");
    
    
    public LogIn_page(WebDriver driver) {
    	this.driver = driver;
    }
    
    public void Enter_Username (String username) {
    	driver.findElement(username_Elm).sendKeys(username);
    }
    
    public void Enter_Password (String password) {
    	driver.findElement(password_Elm).sendKeys(password);
    }
    
    public void Click_Login () {
    	driver.findElement(loginButton_Elm).click();
    }
    
    public boolean verify_the_App_Logo_exists() {
    	return driver.findElement(logo_Elm).isDisplayed();
    }
    
    public String Get_error_Message() {
    	return driver.findElement(errorMessage_Elm).getText();
    }

}
