package listeners_utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base_utlitiy.BaseClass;
import generic_utlitiy.JavaUtility;

public class List_Imp implements ITestListener {

	ExtentReports report;

	@Override
	public void onStart(ITestContext context) {
		long time = JavaUtility.getTodaysDateTime();
//		report configuration => ExtentSparkReporter  and ExtentReports 
		ExtentSparkReporter spark = new ExtentSparkReporter("./advance_reports/" + time + ".html");
		spark.config().setDocumentTitle("dummy fb title");
		spark.config().setReportName("dummy report name");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("browser", "chrome");
		report.setSystemInfo("o.s.", "windows");
	}

	@Override
	public void onFinish(ITestContext context) {
//		report backup
		report.flush();
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTest test = report.createTest(result.getName());
		test.log(Status.PASS, result.getName() + " got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTest test = report.createTest(result.getName());
		test.log(Status.FAIL, result.getName() + " got failed");
		
		TakesScreenshot tks = (TakesScreenshot) BaseClass.sdriver;
		String ss = tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(ss);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTest test = report.createTest(result.getName());
		test.log(Status.SKIP, result.getName() + " got skipped");
	}
}
