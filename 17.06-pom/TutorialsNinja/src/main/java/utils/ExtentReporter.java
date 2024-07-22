package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ExtentReporter {

    public static ExtentReports generateExtentReport() {
        ExtentReports extentReports = new ExtentReports();
        File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(extentReportFile);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setReportName("TutorialsNinja Test Automation Results Report!");
        extentSparkReporter.config().setDocumentTitle("TN Automation Report");
        extentSparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

        extentReports.attachReporter(extentSparkReporter);

        Properties configProp = new Properties();
        File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(configPropFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            configProp.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        extentReports.setSystemInfo("Application URL", configProp.getProperty("url"));
        extentReports.setSystemInfo("Browser Name", configProp.getProperty("browserName"));
        extentReports.setSystemInfo("Email", configProp.getProperty("validEmail"));
        extentReports.setSystemInfo("Password", configProp.getProperty("validPassword"));
        extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReports.setSystemInfo("Username", System.getProperty("user.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));

        return extentReports;
    }
}




















