package testng_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ICOrgTest {

//	invocationCount => To execute same test script multiple times
//	with the same set of data
	
//	dataProvider     => To execute same test script multiple times
//	with the diff set of data => 2D object array => instagram credentials for 5 users


	@Test(invocationCount = 3, threadPoolSize = 3)
	public void createOrgTest() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(3000);
		System.out.println("created qspiders");
		driver.quit();
	}
	
	@Test(invocationCount = 2)
	public void modifyOrgTest() {
		Assert.assertTrue(false);
		System.out.println("modified qspiders to spiders");
	}
	
	@Test(invocationCount = 1)
	public void deleteOrgTest() {
		System.out.println("deleted spiders");
	}
}