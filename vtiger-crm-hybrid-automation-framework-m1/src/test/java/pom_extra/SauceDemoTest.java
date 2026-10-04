package pom_extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import object_repository_saucedemo.SauceDemoPage;

public class SauceDemoTest {

	public static void main(String[] args) throws InterruptedException {

		// =========================================================
		// PAGE 1: LOGIN PAGE
		// =========================================================

		// Open Browser
		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Open SauceDemo Login Page
		driver.get("https://www.saucedemo.com/");

		System.out.println("SauceDemo application opened");

		// Create Page Object
		SauceDemoPage sdp = new SauceDemoPage(driver);

		// Login Elements
		WebElement usernameField = sdp.getUsernameField();

		WebElement passwordField = sdp.getPasswordField();

		WebElement loginButton = sdp.getLoginButton();

		// Enter Login Credentials
		usernameField.sendKeys("standard_user");

		passwordField.sendKeys("secret_sauce");

		loginButton.click();

		Thread.sleep(2000);

		System.out.println("Login button clicked");

		// Verify Login
		String currentUrl = driver.getCurrentUrl();

		if (currentUrl.contains("inventory.html")) {

			System.out.println("Login successful");

		} else {

			System.out.println("Login failed");
		}

		// =========================================================
		// PAGE 2: PRODUCTS / INVENTORY PAGE
		// =========================================================

		// Add Sauce Labs Backpack to Cart
		WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));

		addToCartButton.click();

		System.out.println("Product added to cart");

		// Verify Cart Count
		WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));

		String cartCount = cartBadge.getText();

		if (cartCount.equals("1")) {

			System.out.println("Cart count verified: " + cartCount);

		} else {

			System.out.println("Cart count verification failed");
		}

		// Open Shopping Cart
		WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));

		cartIcon.click();

		Thread.sleep(1000);

		System.out.println("Shopping cart opened");

		// =========================================================
		// PAGE 3: SHOPPING CART PAGE
		// =========================================================

		// Verify Product in Cart
		WebElement productName = driver.findElement(By.className("inventory_item_name"));

		String actualProduct = productName.getText();

		if (actualProduct.equals("Sauce Labs Backpack")) {

			System.out.println("Product verified in cart: " + actualProduct);

		} else {

			System.out.println("Product verification failed");
		}

		// Click Checkout
		WebElement checkoutButton = driver.findElement(By.id("checkout"));

		checkoutButton.click();

		Thread.sleep(1000);

		System.out.println("Checkout button clicked");

		// =========================================================
		// PAGE 4: CHECKOUT - YOUR INFORMATION PAGE
		// =========================================================

		// Enter Customer Information
		WebElement firstName = driver.findElement(By.id("first-name"));

		WebElement lastName = driver.findElement(By.id("last-name"));

		WebElement postalCode = driver.findElement(By.id("postal-code"));

		firstName.sendKeys("Piyush");

		lastName.sendKeys("Baldaniya");

		postalCode.sendKeys("201301");

		System.out.println("Customer information entered");

		// Click Continue
		WebElement continueButton = driver.findElement(By.id("continue"));

		continueButton.click();

		Thread.sleep(1000);

		System.out.println("Continue button clicked");

		// =========================================================
		// PAGE 5: CHECKOUT - OVERVIEW PAGE
		// =========================================================

		// Verify Product on Overview Page
		WebElement overviewProduct = driver.findElement(By.className("inventory_item_name"));

		String overviewProductName = overviewProduct.getText();

		if (overviewProductName.equals("Sauce Labs Backpack")) {

			System.out.println("Product verified on checkout overview: " + overviewProductName);

		} else {

			System.out.println("Checkout product verification failed");
		}

		// Verify Payment Information
		WebElement paymentInfo = driver.findElement(By.className("summary_value_label"));

		System.out.println("Payment information: " + paymentInfo.getText());

		// Verify Total Amount
		WebElement totalAmount = driver.findElement(By.className("summary_total_label"));

		System.out.println("Total amount: " + totalAmount.getText());

		// Click Finish
		WebElement finishButton = driver.findElement(By.id("finish"));

		finishButton.click();

		Thread.sleep(1500);

		System.out.println("Finish button clicked");

		// =========================================================
		// PAGE 6: CHECKOUT COMPLETE / ORDER CONFIRMATION PAGE
		// =========================================================

		// Verify Order Completion Message
		WebElement successMessage = driver.findElement(By.className("complete-header"));

		String actualMessage = successMessage.getText();

		if (actualMessage.equals("Thank you for your order!")) {

			System.out.println("Order placed successfully");

		} else {

			System.out.println("Order placement verification failed");
		}

		// Verify Checkout Complete URL
		String orderUrl = driver.getCurrentUrl();

		if (orderUrl.contains("checkout-complete.html")) {

			System.out.println("Checkout completed successfully");

		} else {

			System.out.println("Checkout completion verification failed");
		}

		// =========================================================
		// PAGE 6: ORDER COMPLETE PAGE
		// Open Menu for Logout
		// =========================================================

		WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));

		menuButton.click();

		Thread.sleep(1000);

		// =========================================================
		// MENU: LOGOUT
		// =========================================================

		WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));

		logoutLink.click();

		Thread.sleep(1500);

		System.out.println("Logout button clicked");

		// =========================================================
		// PAGE 7: LOGIN PAGE AFTER LOGOUT
		// =========================================================

		// Verify Logout
		String logoutUrl = driver.getCurrentUrl();

		if (logoutUrl.equals("https://www.saucedemo.com/")) {

			System.out.println("Logout successful");

		} else {

			System.out.println("Logout failed");
		}

		// =========================================================
		// CLOSE BROWSER
		// =========================================================

		driver.quit();

		System.out.println("Browser closed");

		// =========================================================
		// TEST COMPLETED
		// =========================================================

		System.out.println("==============================================");

		System.out.println("END-TO-END SAUCEDEMO TEST COMPLETED");

		System.out.println("==============================================");
	}
}