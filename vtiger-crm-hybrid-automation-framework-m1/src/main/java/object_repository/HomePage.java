package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	// ==========================================
	// INITIALIZATION
	// ==========================================

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ==========================================
	// DECLARATION (@FindBy)
	// ==========================================

	// Module Elements
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;


	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	// Logout Elements
	@FindBy(css = "[src='themes/softed/images/user.PNG']")
	private WebElement profileIcon;

	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;

	// ==========================================
	// GETTERS
	// ==========================================

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProfileIcon() {
		return profileIcon;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}
	
	public WebElement getSignOutLink() {
		return signOutLink;
	}
}