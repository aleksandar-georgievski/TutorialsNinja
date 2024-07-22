package Tests;

import Pages.HomePage;
import Pages.ProductsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class SeleniumTest {
    public static WebDriver driver;
    static ExtentReports report;
    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();
    @BeforeSuite
    public static void setUp() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/");
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
        HomePage.click_hamburger_menu();
        HomePage.click_orderProducts_link();
    }

    @Test
    public void validateTitles_OnlineProducts() {
        test = extent.createTest("Validate Shoe Titles on Products Page",
                "This test validates that the different Shoe types are correct on Online Products Page");
        ProductsPage.formalShoes_verifyTitle();
        ProductsPage.sportsShoes_verifyTitle();
        ProductsPage.sneakers_verifyTitle();
        extent.flush();
    }

    @Test
    public void validateFirstFormalShoes() {
        test = extent.createTest("Validate First Formal Shoe name",
                "This test validates first formal shoe name on Online Products Page");
        ProductsPage.formalShoes_firstShoe_verify();
    }

    @Test
    public void validateFirstSportsShoes() {
        test = extent.createTest("Validate First Sports Shoe name",
                "This test validates first sport shoe name on Online Products Page");
        ProductsPage.sportsShoes_firstShoe_verify();
    }

    @Test
    public void validateFirstSneakersShoes() {
        test = extent.createTest("Validate First Sneaker Shoe name",
                "This test validates first sneaker shoe name on Online Products Page");
        ProductsPage.sneakers_firstShoe_verify();
    }

    @AfterSuite
    public void tearDown() {
//        driver.quit();
        extent.flush();
    }
}
