package crm.vtiger.contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import generic_utlitiy.FileUtility;
import object_repository.ContactPage;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.VerifyContactPage;

/**
 * Test Script Name : CreateContactTest
 *
 * Application : Vtiger CRM Module : Contacts Test Scenario : Create a new
 * Contact
 *
 * Description: This test script automates the creation of a new Contact in the
 * Vtiger CRM application using Page Object Model.
 *
 * Author : Piyush Baldaniya
 */
public class CreateContactTest {

	public static void main(String[] args) throws InterruptedException, IOException, ParseException {

//		Get data from properties file
		String url = FileUtility.getDataFromJsonFile("url");
		String un = FileUtility.getDataFromJsonFile("un");
		String pwd = FileUtility.getDataFromJsonFile("pwd");

//		Get test script data from excel file
		String lastName = FileUtility.getDataFromExcelFile("contact", 5, 0);

		// ============================================================
		// 1. OPEN THE BROWSER
		// ============================================================

		System.out.println("====================================================");
		System.out.println("TEST EXECUTION STARTED");
		System.out.println("Test Case : Create Contact");
		System.out.println("====================================================");

		System.out.println("[INFO] Launching Chrome browser...");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Instantiate ContactPage object
		ContactPage cp = new ContactPage(driver);
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		VerifyContactPage vcp = new VerifyContactPage(driver);

		// ============================================================
		// 2. LOGIN
		// ============================================================

		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 1] Navigating to Vtiger CRM application...");

		driver.get(url);

		System.out.println("[INFO] Vtiger CRM application opened.");

		WebElement username = lp.getUsernameField();
		WebElement password = lp.getPasswordField();
		WebElement loginBtn = lp.getLoginButton();

		System.out.println("[INFO] Login page elements identified.");

		username.sendKeys(un);
		System.out.println("[INFO] Username entered.");

		password.sendKeys(pwd);
		System.out.println("[INFO] Password entered.");

		loginBtn.click();

		System.out.println("[INFO] Login button clicked.");
		System.out.println("[INFO] Login operation completed.");

		// ============================================================
		// 3. CREATE CONTACT
		// ============================================================

		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 2] Navigating to Contacts module...");

		hp.getContactsLink().click();
		System.out.println("[INFO] Contacts module opened.");

		cp.getCreateContactLookupImg().click();
		System.out.println("[INFO] Create Contact page opened.");
		System.out.println("[INFO] Contact Last Name : " + lastName);

		WebElement lastNameField = cp.getLastNameEdt();
		System.out.println("[INFO] Contact last name field identified.");

		lastNameField.sendKeys(lastName);
		System.out.println("[INFO] Contact last name entered successfully.");

		// ============================================================
		// 4. SAVE CONTACT
		// ============================================================

		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 3] Saving Contact...");

		cp.getSaveBtn().click();

		System.out.println("[INFO] Save button clicked.");
		System.out.println("[INFO] Contact save operation completed.");

		// ============================================================
		// 5. VERIFICATION
		// ============================================================

		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 4] Verifying Contact creation...");

		String actLastName = vcp.getContactHeaderInfo().getText();

		System.out.println("[INFO] Expected Contact Last Name : " + lastName);
		System.out.println("[INFO] Actual Contact Last Name   : " + actLastName);

		if (actLastName.equals(lastName)) {
			System.out.println("[PASS] Contact created successfully !!!");
		} else {
			System.out.println("[FAIL] Contact creation failed...");
		}

		// ============================================================
		// 6. LOGOUT
		// ============================================================

		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 5] Logging out from Vtiger CRM...");

		WebElement profileIcon = hp.getProfileIcon();
		System.out.println("[INFO] Profile icon identified.");

		Actions act = new Actions(driver);
		act.moveToElement(profileIcon).build().perform();
		System.out.println("[INFO] Mouse moved to profile icon.");

		hp.getSignOutLink().click();
		System.out.println("[INFO] Sign Out option clicked.");
		System.out.println("[INFO] Logout completed successfully.");

		// ============================================================
		// 7. CLOSE THE BROWSER
		// ============================================================

		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 6] Closing browser...");

		Thread.sleep(1000);

		driver.quit();
		System.out.println("[INFO] Browser closed successfully.");

		// ============================================================
		// TEST EXECUTION COMPLETED
		// ============================================================

		System.out.println("====================================================");
		System.out.println("TEST EXECUTION COMPLETED");
		System.out.println("Test Case : Create Contact");
		System.out.println("====================================================");
	}
}