package base_utlitiy;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import generic_utlitiy.FileUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeClass
	public void setUp() throws IOException, ParseException {
		driver = new ChromeDriver();
		sdriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(FileUtility.getDataFromJsonFile("url"));
	}

	@BeforeMethod
	public void login() {
		LoginPage lp = new LoginPage(driver);
		lp.login("admin", "admin");
	}

	@AfterMethod
	public void logOut() {
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
