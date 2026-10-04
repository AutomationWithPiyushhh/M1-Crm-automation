package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// ==========================================
	// INITIALIZATION
	// ==========================================

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ==========================================
	// DECLARATION (@FindBy)
	// ==========================================

	// Login Elements
	@FindBy(name = "user_name")
	private WebElement usernameField;

	@FindBy(name = "user_password")
	private WebElement passwordField;

	@FindBy(id = "submitButton")
	private WebElement loginButton;

	// ==========================================
	// GETTERS
	// ==========================================

	public WebElement getUsernameField() {
		return usernameField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

}