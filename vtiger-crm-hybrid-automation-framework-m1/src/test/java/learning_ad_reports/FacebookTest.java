package learning_ad_reports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class FacebookTest {
	@Test
	public void login() {
//		report configuration => ExtentSparkReporter  and ExtentReports 
		ExtentSparkReporter spark = new ExtentSparkReporter("./advance_reports/adRep.html");
		spark.config().setDocumentTitle("dummy fb title");
		spark.config().setReportName("dummy report name");
		spark.config().setTheme(Theme.DARK);

		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("browser", "chrome");
		report.setSystemInfo("o.s.", "windows");

//		report generation
		ExtentTest test = report.createTest("login");
		test.log(Status.PASS, "This is passed");
		test.log(Status.FAIL, "This is failed");
		test.log(Status.SKIP, "This is skipped");
		test.log(Status.WARNING, "This is just warning");
		test.log(Status.INFO, "This is just info");

//		report backup
		report.flush();
	}
}
