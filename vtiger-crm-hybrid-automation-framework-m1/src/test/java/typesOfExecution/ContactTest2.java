package typesOfExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ContactTest2 {

	@Test
	public void createContactTest() throws InterruptedException {
		WebDriver driver = null;
		String browser = "chrome";
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		Thread.sleep(3000);
		driver.quit();
	}

	@Test(groups = "regression", enabled = false)
	public void modifyContactTest() {
		System.out.println("Contact modified");
	}

	@Test(groups = "regression", enabled = false)
	public void deleteContactTest() {
		System.out.println("Contact deleted");
	}
}
