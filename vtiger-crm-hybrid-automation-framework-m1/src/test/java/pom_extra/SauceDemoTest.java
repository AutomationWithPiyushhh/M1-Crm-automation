package pom_extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import object_repository_saucedemo.SauceDemoPage;

public class SauceDemoTest {

	public static void main(String[] args) throws InterruptedException {
//		Open browser
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.saucedemo.com/");

		SauceDemoPage sdp = new SauceDemoPage(driver);

		// Login elements stored in reference variables
//		WebElement usernameField = driver.findElement(By.id("user-name"));
//		WebElement passwordField = driver.findElement(By.id("password"));
//		WebElement loginButton = driver.findElement(By.id("login-button"));

		WebElement usernameField = sdp.getUsernameField();
		WebElement passwordField = sdp.getPasswordField();
		WebElement loginButton = sdp.getLoginButton();

//		driver.navigate().refresh();

//		utilization
		usernameField.sendKeys("standard_user");
		passwordField.sendKeys("secret_sauce");
		loginButton.click();

		Thread.sleep(2000);

		// Verify login
		String currentUrl = driver.getCurrentUrl();

		if (currentUrl.contains("inventory.html")) {
			System.out.println("Login successful");
		} else {
			System.out.println("Login failed");
		}

		// Logout elements stored in reference variables
		WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
		menuButton.click();

		Thread.sleep(1000);

		WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
		logoutLink.click();

		Thread.sleep(2000);

		// Verify logout
		if (driver.getCurrentUrl().equals("https://www.saucedemo.com/")) {
			System.out.println("Logout successful");
		} else {
			System.out.println("Logout failed");
		}

		// Close browser
		driver.quit();
	}
}