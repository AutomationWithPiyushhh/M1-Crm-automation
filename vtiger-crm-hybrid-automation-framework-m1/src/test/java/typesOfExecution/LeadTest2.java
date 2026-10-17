package typesOfExecution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LeadTest2 {

	@Test
	public void createLeadTest() throws InterruptedException {
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

	@Test(groups = { "smoke", "regression" }, enabled = false)
	public void modifyLeadTest() {
		System.out.println("lead modified");
	}

	@Test(groups = "regression", enabled = false)
	public void deleteLeadTest() {
		System.out.println("lead deleted");
	}
}
