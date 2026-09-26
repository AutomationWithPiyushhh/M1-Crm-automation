package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	// ==========================================
	// INITIALIZATION
	// ==========================================

	public ContactPage(WebDriver driver) {
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

	// Contact Module Elements
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(css = "[title='Create Contact...']")
	private WebElement createContactLookupImg;
	
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(className = "save")
	private WebElement saveBtn;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement contactHeaderInfo;
	
	// Logout Elements
	@FindBy(css = "[src='themes/softed/images/user.PNG']")
	private WebElement profileIcon;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

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

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getCreateContactLookupImg() {
		return createContactLookupImg;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getContactHeaderInfo() {
		return contactHeaderInfo;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
}