package crm.vtiger.contact;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_utlitiy.BaseClass;
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

@Listeners(listeners_utility.List_Imp.class)
public class ContactTest extends BaseClass {

	@Test
	public void createContactTest() throws IOException, ParseException {

//		Get test script data from excel file
		String lastName = FileUtility.getDataFromExcelFile("contact", 5, 0);

		// ============================================================
		// 1. OPEN THE BROWSER
		// ============================================================

		// Instantiate ContactPage object
		ContactPage cp = new ContactPage(driver);
		LoginPage lp = new LoginPage(driver);
		HomePage hp = new HomePage(driver);
		VerifyContactPage vcp = new VerifyContactPage(driver);

		// ============================================================
		// 2. LOGIN
		// ============================================================

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

		Assert.assertEquals(actLastName, lastName + "abc");

		// ============================================================
		// 6. LOGOUT
		// ============================================================

		// ============================================================
		// 7. CLOSE THE BROWSER
		// ============================================================

		// ============================================================
		// TEST EXECUTION COMPLETED
		// ============================================================

		System.out.println("====================================================");
		System.out.println("TEST EXECUTION COMPLETED");
		System.out.println("Test Case : Create Contact");
		System.out.println("====================================================");
	}
}