package TestCases;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class Login extends Base {
    // From Base/Base.java, with constructor
    public Login() {
        super();
    }
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
//        loadPropertiesFile(); ---- From Base/Base.java, without constructor
//        driver = initializeBrowserAndOpenApplicationURL("firefox"); ----- Old way of writing it hard coded
        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMyAccount();
        homePage.selectLoginOption();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void verifyLoginWithValidCredentials() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAddress(prop.getProperty("validEmail"));
//        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
        loginPage.enterPassword(prop.getProperty("validPassword"));
//        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
        loginPage.clickOnLoginPage();
//        driver.findElement(By.xpath("//input[@value='Login']")).click();
        AccountPage accountPage = new AccountPage(driver);
//        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),"Edit Your Account Information option is not displayed");
        Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption(), "Edit Your Account Information option is not displayed");
    }

    @Test(priority = 2)
    public void verifyLoginWithInvalidCredentials() {
//        driver.findElement(By.id("input-email")).sendKeys(dataprop.getProperty("invalidEmail"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAddress(dataprop.getProperty("invalidEmail"));
//        driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidPassword"));
        loginPage.enterPassword(dataprop.getProperty("invalidPassword"));
//        driver.findElement(By.xpath("//input[@value='Login']")).click();
        loginPage.clickOnLoginPage();
//        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
        String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
        String expectedWarningMessage = dataprop.getProperty("emailPasswordWarningMessage");
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
    }
}