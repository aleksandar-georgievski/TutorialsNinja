package testcases;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.Utilities;

public class Login extends Base {

    LoginPage loginPage;
    AccountPage accountPage;

    public Login() {
        super();
    }

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
        HomePage homePage = new HomePage(driver);
        loginPage = homePage.navigateToLoginPage();
//        homePage.clickOnMyAccount();
//        loginPage = homePage.selectLoginOption();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void verifyLoginWithValidCredentials() {
        loginPage.enterEmailAddress(prop.getProperty("validEmail"));
        loginPage.enterPassword(prop.getProperty("validPassword"));
        accountPage = loginPage.clickOnLoginButton();
//        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
//        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//        driver.findElement(By.xpath("//input[@value='Login']")).click();
        accountPage.getDisplayStatusOfEditYourAccountInformationOption();
        Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption(), "Edit Your Account Information option is not displayed");
//        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(), "Edit Your Account Information option is not displayed");
    }

    @Test(priority = 2)
    public void verifyLoginWithInvalidCredentials() {
        loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
        loginPage.enterPassword(testProp.getProperty("invalidPassword"));
        loginPage.clickOnLoginButton();
//        driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
//        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty(testProp.getProperty("invalidPassword")));
//        driver.findElement(By.xpath("//input[@value='Login']")).click();

        String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
//        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
        String expectedWarningMessage = testProp.getProperty("emailPasswordNoMatchWarning");
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning Message is not displayed");
    }

    @Test(priority = 3)
    public void verifyLoginWithInvalidEmailAndValidPassword() {
        loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
        loginPage.enterPassword(prop.getProperty("validPassword"));
        loginPage.clickOnLoginButton();
//        driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
//        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//        driver.findElement(By.xpath("//input[@value='Login']")).click();

        String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
//        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
        String expectedWarningMessage = testProp.getProperty("emailPasswordNoMatchWarning");
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning Message is not displayed");
    }

    @Test(priority = 4)
    public void verifyLoginWithValidEmailAndInvalidPassword() {
        loginPage.enterEmailAddress(prop.getProperty("validEmail"));
        loginPage.enterPassword(testProp.getProperty("invalidPassword"));
        loginPage.clickOnLoginButton();
//        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
//        driver.findElement(By.id("input-password")).sendKeys(testProp.getProperty("invalidPassword"));
//        driver.findElement(By.xpath("//input[@value='Login']")).click();

        String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
//        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
        String expectedWarningMessage = testProp.getProperty("emailPasswordNoMatchWarning");
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning Message is not displayed");
    }

    @Test(priority = 5)
    public void verifyLoginWithoutProvidingCredentials() {
        loginPage.clickOnLoginButton();
//        driver.findElement(By.xpath("//input[@value='Login']")).click();

        String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
//        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
        String expectedWarningMessage = testProp.getProperty("emailPasswordNoMatchWarning");
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"Expected Warning Message is not displayed");
    }

}
