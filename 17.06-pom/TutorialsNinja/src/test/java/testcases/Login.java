package testcases;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Utilities;


import static utils.Utilities.generateEmailWithTimeStamp;

public class Login extends Base {
    WebDriver driver;
    public Login() {
        super();
    }


    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void verifyLoginWithValidCredentials() {
        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(), "Edit your account information option is not displayed");
    }

    @Test(priority = 2)
    public void verifyLoginWithInvalidCredentials() {
        driver.findElement(By.id("input-email")).sendKeys(generateEmailWithTimeStamp());
        driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
        String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is not displayed");
    }

    @Test(priority = 3)
    public void verifyLoginWithInvalidEmailAndValidPassword() {
        driver.findElement(By.id("input-email")).sendKeys(generateEmailWithTimeStamp());
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
        String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is not displayed");
    }

    @Test(priority = 4)
    public void verifyLoginWithValidEmailAndInvalidPassword() {
        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
        driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
        String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is not displayed");
    }

    @Test(priority = 5)
    public void verifyLoginWithoutProvidingCredentials() {
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
        String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarning");
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is not displayed");
    }
    @Test(priority = 6)
    public void verifyForgottenPasswordIsDisplayedInLoginPage() {
        String forgottenPasswordText = driver.findElement(By.xpath("//div[@class='form-group']//a")).getText();
        String actualForgottenPasswordText = "Forgotten Password";
        Assert.assertEquals(forgottenPasswordText, actualForgottenPasswordText, "Forgotten Password Link is not displayed");
    }

    @Test(priority = 7)
    public void verifyPlaceholderText() {
        String getEmailPlaceholderText = driver.findElement(By.id("input-email")).getAttribute("placeholder");
        String getPasswordPlaceholderText = driver.findElement(By.id("input-password")).getAttribute("placeholder");
        Assert.assertTrue(getEmailPlaceholderText.contains("E-Mail Address"));
        Assert.assertEquals(getPasswordPlaceholderText, "Password");
    }

}












