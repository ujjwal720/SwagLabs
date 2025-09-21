package Utility;

import Pages.DriverInit;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Listners implements ITestListener {

    public static ExtentReports reports;
    public static ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {
        reports = ReportsUtility.reportsInit();
    }

    @Override
    public void onTestStart(ITestResult result) {
        extentTest = ReportsUtility.createTest(reports, result.getMethod().getMethodName());
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS,result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL,result.getMethod().getMethodName());
        String screenshotPath = ScreenshotUtility.takeScreenshot();
        if (screenshotPath != null) {
            try {
                extentTest.addScreenCaptureFromPath(screenshotPath, "Screenshot on Failure");
            } catch (Exception e) {
                extentTest.log(Status.WARNING, "Failed to attach screenshot: " + e.getMessage());
            }
        } else {
            extentTest.log(Status.WARNING, "Screenshot capture failed.");
        }
        // Attach screenshot to Allure on failure
        try {
            ScreenshotUtility2.captureScreenshot();
        } catch (Exception e) {
            // Optionally log or handle
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }



    @Override
    public void onFinish(ITestContext context) {

        reports.flush();

    }
}
