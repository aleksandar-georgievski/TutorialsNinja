package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReporter;
import utils.Utilities;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MyListeners implements ITestListener {
    ExtentReports extentReport;
    ExtentTest extentTest;
//    String testName;

    @Override
    public void onStart(ITestContext context) {
        extentReport = ExtentReporter.generateExtentReport();
    }
    @Override
    public void onTestStart(ITestResult result) {
//        testName = result.getName();
        extentTest = extentReport.createTest(result.getName());
        extentTest.log(Status.INFO, result.getName()+" started executing");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
//        testName = result.getName();
        extentTest.log(Status.PASS, result.getName()+" got successfully executed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
//        testName = result.getName();

        WebDriver driver = null;
        try {
            driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

//        File srcScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        String destinationScreenShotPath = System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
//        try {
//            FileHandler.copy(srcScreenShot, new File(destinationScreenShotPath));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        String destinationScreenShotPath = Utilities.captureScreenshot(driver, result.getName());

        extentTest.addScreenCaptureFromPath(destinationScreenShotPath);
        extentTest.log(Status.INFO, result.getThrowable());
        extentTest.log(Status.FAIL, result.getName()+" got failed");
        extentTest.log(Status.INFO, "test is okay");
    }
    @Override
    public void onTestSkipped(ITestResult result) {
//        testName = result.getName();
        extentTest.log(Status.INFO, result.getThrowable());
        extentTest.log(Status.SKIP, result.getName()+" got skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReport.flush();
        String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
        File extentReport = new File(pathOfExtentReport);
        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
