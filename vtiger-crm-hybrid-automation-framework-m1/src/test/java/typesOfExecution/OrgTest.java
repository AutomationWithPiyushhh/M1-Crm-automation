package typesOfExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrgTest {

	@Parameters("bro")
	@Test
	public void createOrgTest(String browser) throws InterruptedException {
		WebDriver driver = null;
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

	@Test(groups = "smoke", enabled = false)
	public void modifyOrgTest() {
		System.out.println("Org modified");
	}

	@Test(groups = "regression", enabled = false)
	public void deleteOrgTest() {
		System.out.println("Org deleted");
	}
}
