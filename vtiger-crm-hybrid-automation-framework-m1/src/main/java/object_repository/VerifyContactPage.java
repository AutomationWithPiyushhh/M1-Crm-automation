package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyContactPage {

	// ==========================================
	// INITIALIZATION
	// ==========================================

	public VerifyContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// ==========================================
	// DECLARATION (@FindBy)
	// ==========================================

	@FindBy(id = "dtlview_Last Name")
	private WebElement contactHeaderInfo;

	// ==========================================
	// GETTERS
	// ==========================================

	public WebElement getContactHeaderInfo() {
		return contactHeaderInfo;
	}
}