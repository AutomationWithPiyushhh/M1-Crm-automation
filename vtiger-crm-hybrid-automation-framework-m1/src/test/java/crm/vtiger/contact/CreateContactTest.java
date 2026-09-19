package crm.vtiger.contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Test Script Name : CreateContactTest
 *
 * Application : Vtiger CRM Module : Contacts Test Scenario : Create a new
 * Contact
 *
 * Description: This test script automates the creation of a new Contact in the
 * Vtiger CRM application.
 *
 * Test Flow: 1. Launch Chrome browser 2. Maximize the browser window 3.
 * Configure implicit wait 4. Navigate to Vtiger CRM application 5. Login using
 * valid credentials 6. Navigate to Contacts module 7. Open Create Contact page
 * 8. Enter Contact last name 9. Save the Contact 10. Verify the created Contact
 * last name 11. Logout from the application 12. Close the browser
 *
 * Expected Result: The Contact should be created successfully and the displayed
 * Contact last name should match the entered last name.
 *
 * Author : Piyush Baldaniya
 */
public class CreateContactTest {

	public static void main(String[] args) throws InterruptedException, IOException {

//		we should never ever hard code the data into our test script
		
//		DDT => testing the application with the help of external resources 
//				and running the script is called as data driven testing
		
//		common data => the data which is common for all test scripts

//		String url = "http://localhost:8888/";
//		String un = "admin";
//		String pwd = "password";

//		get data from properties file
		FileInputStream fis = new FileInputStream("./src/test/resources/cd.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String url = pObj.getProperty("url");
		String un = pObj.getProperty("username");
		String pwd = pObj.getProperty("password");

		
//		test script data => the data which is common for particular test scripts
//		String lastName = "Sharma";
		
		FileInputStream fis1 = new FileInputStream("./src/test/resources/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("contact");
		Row row = sh.getRow(5);
		Cell cell = row.getCell(0);
		String lastName = cell.getStringCellValue();
		

		// ============================================================
		// 1. OPEN THE BROWSER
		// ============================================================

		System.out.println("====================================================");
		System.out.println("TEST EXECUTION STARTED");
		System.out.println("Test Case : Create Contact");
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

		driver.get(url);

		System.out.println("[INFO] Vtiger CRM application opened.");

		WebElement username = driver.findElement(By.name("user_name"));
		WebElement password = driver.findElement(By.name("user_password"));
		WebElement loginBtn = driver.findElement(By.id("submitButton"));

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

		driver.findElement(By.linkText("Contacts")).click();

		System.out.println("[INFO] Contacts module opened.");

		driver.findElement(By.cssSelector("[title='Create Contact...']")).click();

		System.out.println("[INFO] Create Contact page opened.");

		System.out.println("[INFO] Contact Last Name : " + lastName);

		WebElement lastNameField = driver.findElement(By.name("lastname"));

		System.out.println("[INFO] Contact last name field identified.");

		lastNameField.sendKeys(lastName);

		System.out.println("[INFO] Contact last name entered successfully.");

		// ============================================================
		// 4. SAVE CONTACT
		// ============================================================

		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 3] Saving Contact...");

		driver.findElement(By.className("save")).click();

		System.out.println("[INFO] Save button clicked.");
		System.out.println("[INFO] Contact save operation completed.");

		// ============================================================
		// 5. VERIFICATION
		// ============================================================

		System.out.println("----------------------------------------------------");
		System.out.println("[STEP 4] Verifying Contact creation...");

		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();

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

		WebElement profileIcon = driver.findElement(By.cssSelector("[src='themes/softed/images/user.PNG']"));

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
		System.out.println("Test Case : Create Contact");
		System.out.println("====================================================");
	}
}