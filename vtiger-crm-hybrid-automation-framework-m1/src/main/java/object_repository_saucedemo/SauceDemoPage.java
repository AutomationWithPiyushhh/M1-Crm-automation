package object_repository_saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoPage {
	
//	initialization
	public SauceDemoPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
//	declaration
	@FindBy(id = "user-name")
	private WebElement usernameField;
	
	public WebElement getUsernameField() {
		return usernameField;
	}
	
	@FindBy(id = "password")
	private WebElement passwordField;
	
	public WebElement getPasswordField() {
		return passwordField;
	}
	
	@FindBy(id = "login-button")
	private WebElement loginButton;
	
	public WebElement getLoginButton() {
		return loginButton;
	}
}
