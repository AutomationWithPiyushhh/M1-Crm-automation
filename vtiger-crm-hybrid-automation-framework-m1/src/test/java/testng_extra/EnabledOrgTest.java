package testng_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnabledOrgTest {


	@Test(enabled = false)
	public void createOrgTest() throws InterruptedException {
		System.out.println("created qspiders");
	}
	
	@Test(invocationCount = 2)
	public void modifyOrgTest() {
		Assert.assertTrue(false);
		System.out.println("modified qspiders to spiders");
	}
	
	@Test(dependsOnMethods = "modifyOrgTest", invocationCount = 5, alwaysRun = true)
	public void deleteOrgTest() { 
		System.out.println("deleted spiders");
	}
}