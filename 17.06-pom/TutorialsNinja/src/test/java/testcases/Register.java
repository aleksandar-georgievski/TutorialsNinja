package testcases;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static utils.Utilities.generateEmailWithTimeStamp;

public class Register extends Base {

    public Register() {
        super();
    }
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test(priority = 1)
    public void verifyRegisteringAnAccountWithMandatoryFields() {
        driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
        driver.findElement(By.id("input-email")).sendKeys(generateEmailWithTimeStamp());
        driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String actualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success Page is not displayed");
    }

    @Test(priority = 2)
    public void verifyRegisteringAccountByProvidingAllFields() {
        driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
        driver.findElement(By.id("input-email")).sendKeys(generateEmailWithTimeStamp());
        driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String actualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success Page is not displayed");
    }

    @Test(priority = 3)
    public void verifyRegisteringAccountWithExistingEmailAddress() {
        driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
        driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
        Assert.assertTrue(actualWarningMessage.contains(dataProp.getProperty("duplicateEmailWarning")), "Warning message is not displayed");
    }

    @Test(priority = 4)
    public void verifyRegisteringAccountWithoutFillingAnyDetails() {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        String actualPrivacyPolicyWarning = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
        Assert.assertTrue(actualPrivacyPolicyWarning.contains(dataProp.getProperty("privacyPolicyWarning")), "Privacy Policy Warning message is not displayed");

        String actualFirstNameWarning = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
        Assert.assertEquals(actualFirstNameWarning, dataProp.getProperty("firstNameWarning"), "First Name Warning message is not displayed");

        String actualLastNameWarning = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
        Assert.assertEquals(actualLastNameWarning, dataProp.getProperty("lastNameWarning"), "Last Name Warning message is not displayed");

        String actualEmailWarning = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
        Assert.assertEquals(actualEmailWarning, dataProp.getProperty("emailWarning"), "Email Warning message is not displayed");

        String actualTelephoneWarning = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
        Assert.assertEquals(actualTelephoneWarning, dataProp.getProperty("telephoneWarning"), "Telephone Warning message is not displayed");

        String actualPasswordWarning = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
        Assert.assertEquals(actualPasswordWarning, dataProp.getProperty("passwordWarning"), "Password Warning message is not displayed");
    }
}
























