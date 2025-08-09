package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager extends BaseClass implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        String reportName = "Test-Report-" + timestamp + ".html";

        sparkReporter = new ExtentSparkReporter("./reports/" + reportName);
        sparkReporter.config().setDocumentTitle("API Automation Report");
        sparkReporter.config().setReportName("API Test Results");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Project", "API Testing");
        extent.setSystemInfo("Tester", "Mohd Aadil");
        extent.setSystemInfo("Time", timestamp);
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test failed: " + result.getMethod().getMethodName());
        test.log(Status.FAIL, "Reason: " + result.getThrowable());
        
        try {
        	String path = GetScreenshot.captureScreenshot(result.getMethod().getMethodName());
        	test.addScreenCaptureFromPath(path);
        }catch(Exception e) {
        	 e.printStackTrace();
        }
        
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test skipped: " + result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
