package crm.vtiger.opp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Test Script Name : CreateOrgTest
 *
 * Application     : Vtiger CRM
 * Module          : Organizations
 * Test Scenario   : Create a new Organization
 *
 * Description:
 * This test script automates the creation of a new Organization
 * in the Vtiger CRM application.
 *
 * Test Flow:
 * 1. Launch Chrome browser
 * 2. Maximize the browser window
 * 3. Configure implicit wait
 * 4. Navigate to Vtiger CRM application
 * 5. Login using valid credentials
 * 6. Navigate to Organizations module
 * 7. Open Create Organization page
 * 8. Generate a unique Organization name
 * 9. Enter Organization name
 * 10. Save the Organization
 * 11. Verify the created Organization name
 * 12. Logout from the application
 * 13. Close the browser
 *
 * Expected Result:
 * The Organization should be created successfully and the
 * displayed Organization name should match the entered name.
 *
 * Author : Piyush Baldaniya
 */
public class CreateOppTest {

	public static void main(String[] args) throws InterruptedException {

		// ============================================================
		// 1. OPEN THE BROWSER
		// ============================================================

		System.out.println("====================================================");
		System.out.println("TEST EXECUTION STARTED");
		System.out.println("Test Case : Create Organization");
		System.out.println("====================================================");

		System.out.println("[INFO] Launching Chrome browser...");

		WebDriver driver = new ChromeDriver();

		System.out.println("[INFO] Chrome browser launched successfully.");

		driver.manage().window().maximize();

		System.out.println("[INFO] Browser window maximized.");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		System.out.println("[INFO] Implicit wait configured to 15 seconds.");

		// ============================================================
		// 2. LOGIN
		// ============================================================

		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 1] Navigating to Vtiger CRM application...");

		driver.get("http://localhost:8888/");

		System.out.println("[INFO] Vtiger CRM application opened.");

		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		WebElement loginBtn = driver.findElement(By.id("submitButton"));

		System.out.println("[INFO] Login page elements identified.");

		username.sendKeys("admin");
		System.out.println("[INFO] Username entered.");

		password.sendKeys("password");
		System.out.println("[INFO] Password entered.");

		loginBtn.click();

		System.out.println("[INFO] Login button clicked.");
		System.out.println("[INFO] Login operation completed.");

		// ============================================================
		// 3. CREATE ORGANIZATION
		// ============================================================

		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 2] Navigating to Organizations module...");

		driver.findElement(By.linkText("Organizations")).click();

		System.out.println("[INFO] Organizations module opened.");

		driver.findElement(By.cssSelector("[title='Create Organization...']")).click();

		System.out.println("[INFO] Create Organization page opened.");

		int number = (int) (Math.random() * 1000);
		String orgName = "automationwithpiyush_" + number;

		System.out.println("[INFO] Generated Organization Name : " + orgName);

		WebElement orgField = driver.findElement(By.name("accountname"));

		System.out.println("[INFO] Organization name field identified.");

		orgField.sendKeys(orgName);

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

		String actOrgName = driver.findElement(
				By.id("dtlview_Organization Name")).getText();

		System.out.println("[INFO] Expected Organization Name : " + orgName);
		System.out.println("[INFO] Actual Organization Name   : " + actOrgName);

		if (actOrgName.equals(orgName)) {

			System.out.println("[PASS] Organization created successfully !!!");

		} else {

			System.out.println("[FAIL] Organization creation failed...");

		}

		// ============================================================
		// 6. LOGOUT
		// ============================================================

		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 5] Logging out from Vtiger CRM...");

		WebElement profileIcon = driver.findElement(
				By.cssSelector("[src='themes/softed/images/user.PNG']"));

		System.out.println("[INFO] Profile icon identified.");

		Actions act = new Actions(driver);

		act.moveToElement(profileIcon).build().perform();

		System.out.println("[INFO] Mouse moved to profile icon.");

		driver.findElement(By.linkText("Sign Out")).click();

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
		System.out.println("Test Case : Create Organization");
		System.out.println("====================================================");
	}
}
