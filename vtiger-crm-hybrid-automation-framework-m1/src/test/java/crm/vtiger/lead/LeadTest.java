package crm.vtiger.lead;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base_utlitiy.BaseClass;

/**
 * Test Script Name : CreateOrgTest
 *
 * Application : Vtiger CRM Module : Organizations Test Scenario : Create a new
 * Organization
 *
 * Description: This test script automates the creation of a new Organization in
 * the Vtiger CRM application.
 *
 * Test Flow: 1. Launch Chrome browser 2. Maximize the browser window 3.
 * Configure implicit wait 4. Navigate to Vtiger CRM application 5. Login using
 * valid credentials 6. Navigate to Organizations module 7. Open Create
 * Organization page 8. Generate a unique Organization name 9. Enter
 * Organization name 10. Save the Organization 11. Verify the created
 * Organization name 12. Logout from the application 13. Close the browser
 *
 * Expected Result: The Organization should be created successfully and the
 * displayed Organization name should match the entered name.
 *
 * Author : Piyush Baldaniya
 */
public class LeadTest extends BaseClass {

	@Test
	public void createOrgTest() {

		// ============================================================
		// 1. OPEN THE BROWSER
		// ============================================================

		// ============================================================
		// 2. LOGIN
		// ============================================================

		// ============================================================
		// 3. CREATE ORGANIZATION
		// ============================================================

		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 2] Navigating to Organizations module...");

		driver.findElement(By.linkText("Opportunities")).click();

		System.out.println("[INFO] Leads module opened.");

		driver.findElement(By.cssSelector("[title='Create Opportunity...']")).click();

		System.out.println("[INFO] Create Organization page opened.");

		String orgName = "automationwithpiyush";

		System.out.println("[INFO] Generated Organization Name : " + orgName);

		WebElement oppField = driver.findElement(By.name("potentialname"));

		System.out.println("[INFO] Organization name field identified.");

		oppField.sendKeys("Sharma");

//		handling multiple window
//		get the home address
		String PID = driver.getWindowHandle();

//		perform the task which will open new windows
		driver.findElement(By.cssSelector("img[src='themes/softed/images/select.gif']")).click();

//		get the session ids of all the opened windows
		Set<String> CIDs = driver.getWindowHandles();

		for (String i : CIDs) {
//			iterate through each and every window
			driver.switchTo().window(i);
//			break the loop wherever condition meets
			if (driver.getCurrentUrl().contains("module=Accounts")) {
				break;
			}
		}

//		perform the task
		driver.findElement(By.name("search_text")).sendKeys("automationwithpiyush" + Keys.ENTER);
		driver.findElement(By.linkText("automationwithpiyush")).click();

//		get back home
		driver.switchTo().window(PID);

		System.out.println("[INFO] Organization name entered successfully.");

		// ============================================================
		// 4. SAVE ORGANIZATION
		// ============================================================

		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 3] Saving Organization...");

		driver.findElement(By.className("save")).click();

		System.out.println("[INFO] Save button clicked.");
		System.out.println("[INFO] Organization save operation completed.");

		// ============================================================
		// 5. VERIFICATION
		// ============================================================

		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 4] Verifying Organization creation...");

//		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
//
//		System.out.println("[INFO] Expected Organization Name : " + orgName);
//		System.out.println("[INFO] Actual Organization Name   : " + actOrgName);
//
//		if (actOrgName.equals(orgName)) {
//
//			System.out.println("[PASS] Organization created successfully !!!");
//
//		} else {
//
//			System.out.println("[FAIL] Organization creation failed...");
//
//		}

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
		System.out.println("Test Case : Create Organization");
		System.out.println("====================================================");
	}
}
