package testcases;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.Utilities;

public class Register extends Base {

    RegisterPage registerPage;
    AccountSuccessPage accountSuccessPage;

    public Register() {
        super();
    }

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMyAccount();
        registerPage = homePage.selectRegisterOption();
//        driver.findElement(By.xpath("//span[text()='My Account']")).click();
//        driver.findElement(By.linkText("Register")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void verifyRegisteringAnAccountWithMandatoryFields() {
        registerPage.enterFirstName(testProp.getProperty("firstName"));
        registerPage.enterLastName(testProp.getProperty("firstName"));
        registerPage.enterEmail(Utilities.generateEmailWithTimeStamp());
        registerPage.enterTelephone(testProp.getProperty("telephoneNumber"));
        registerPage.enterPassword(prop.getProperty("validPassword"));
        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
        registerPage.selectPrivacyPolicyField();
        registerPage.clickOnContinueButton();
//        driver.findElement(By.id("input-firstname")).sendKeys(testProp.getProperty("firstName"));
//        driver.findElement(By.id("input-lastname")).sendKeys(testProp.getProperty("lastName"));
//        driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
//        driver.findElement(By.id("input-telephone")).sendKeys(testProp.getProperty("telephoneNumber"));
//        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
//        driver.findElement(By.name("agree")).click();
//        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
        String actualSuccessHeading = accountSuccessPage.retrieveAccountSuccessPageHeading();
//        String actualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        Assert.assertEquals(actualSuccessHeading, testProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success page is not displayed");
    }

    @Test(priority = 2)
    public void verifyRegisteringAnAccountByProvidingAllFields() {
        registerPage.enterFirstName(testProp.getProperty("firstName"));
        registerPage.enterLastName(testProp.getProperty("firstName"));
        registerPage.enterEmail(Utilities.generateEmailWithTimeStamp());
        registerPage.enterTelephone(testProp.getProperty("telephoneNumber"));
        registerPage.enterPassword(prop.getProperty("validPassword"));
        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
        registerPage.selectNewsletterOption();
        registerPage.selectPrivacyPolicyField();
        accountSuccessPage = registerPage.clickOnContinueButton();
//        driver.findElement(By.id("input-firstname")).sendKeys(testProp.getProperty("firstName"));
//        driver.findElement(By.id("input-lastname")).sendKeys(testProp.getProperty("lastName"));
//        driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
//        driver.findElement(By.id("input-telephone")).sendKeys(testProp.getProperty("telephoneNumber"));
//        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
//        driver.findElement(By.xpath("//input[@name='newsletter']")).click();
//        driver.findElement(By.name("agree")).click();
//        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        String actualSuccessHeading = accountSuccessPage.retrieveAccountSuccessPageHeading();
//        String actualSuccessHeading = driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
        Assert.assertEquals(actualSuccessHeading, testProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success page is not displayed");
    }

    @Test(priority = 3)
    public void verifyRegisteringAnAccountWithExistingEmailAddress() {
        driver.findElement(By.id("input-firstname")).sendKeys(testProp.getProperty("firstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(testProp.getProperty("lastName"));
        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
        driver.findElement(By.id("input-telephone")).sendKeys(testProp.getProperty("telephoneNumber"));
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.xpath("//input[@name='newsletter']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String actualWarning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
        Assert.assertTrue(actualWarning.contains(testProp.getProperty("duplicateEmailWarning")), "Warning message is not displayed");
    }

    @Test(priority = 4)
    public void verifyRegisteringAnAccountWithoutFillingAnyDetails() {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        String actualPrivacyPolicyWarning = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
        Assert.assertTrue(actualPrivacyPolicyWarning.contains(testProp.getProperty("privacyPolicyWarning")), "Privacy Policy warning message is not displayed");

        String actualFirstNameWarning = driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText();
        Assert.assertEquals(actualFirstNameWarning, testProp.getProperty("firstNameWarning"),"First Name warning message is not displayed");

        String actualLastNameWarning = driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText();
        Assert.assertEquals(actualLastNameWarning, testProp.getProperty("lastNameWarning"), "Last Name warning message is not displayed");

        String actualEmailWarning = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText();
        Assert.assertEquals(actualEmailWarning, testProp.getProperty("emailAddressWarning"), "Email warning message is not displayed");

        String actualTelephoneWarning = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
        Assert.assertEquals(actualTelephoneWarning, testProp.getProperty("telephoneWarning"), "Telephone warning message is not displayed");

        String actualPasswordWarning = driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
        Assert.assertEquals(actualPasswordWarning, testProp.getProperty("passwordWarning"), "Password warning message is not displayed");
    }
}


















