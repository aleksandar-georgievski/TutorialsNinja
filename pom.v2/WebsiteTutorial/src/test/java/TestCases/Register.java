package TestCases;

import Base.Base;
import Utils.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;


public class Register extends Base {

    public Register() {
        super();
    }
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
//        driver = initializeBrowserAndOpenApplicationURL("firefox");
        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
        HomePage homePage = new HomePage(driver);
        homePage.clickOnMyAccount();
//        driver.findElement(By.xpath("//span[text()='My Account']")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void verifyRegisteringAnAccountWithMandatoryFields() {
//        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        HomePage homePage = new HomePage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        driver.findElement(By.linkText("Register")).click();
        homePage.selectRegisterOption();
//        driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstName"));
        registerPage.enterFirstName(dataprop.getProperty("firstName"));
//        driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastName"));
        registerPage.enterLastName(dataprop.getProperty("lastName"));
//        driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
        registerPage.enterEmail(Utilities.generateEmailWithTimeStamp());
//        driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("phoneNumber"));
        registerPage.enterTelephone(dataprop.getProperty("phoneNumber"));
//        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
        registerPage.enterPassword(prop.getProperty("validPassword"));
//        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//        driver.findElement(By.xpath("//input[@type='radio'][@value=0]")).click();
        registerPage.clickSubscribeButton();
//        driver.findElement(By.xpath("//input[@type='checkbox'][@name='agree']")).click();
        registerPage.clickPrivacyPolicyField();
//        driver.findElement(By.xpath("//input[@type='submit'][@value='Continue']")).click();
        registerPage.clickContinueButton();
//        String successHeadingText = driver.findElement(By.xpath("//div[@id='content']//h1")).getText();
        String successHeadingText = registerPage.getSuccessHeadingText();
        Assert.assertEquals(successHeadingText, dataprop.getProperty("accountSuccessfullyCreatedHeading"), "Account Success page is not displayed");
//        driver.findElement(By.xpath("//a[contains(text(), 'Continue')]")).click();
        registerPage.getCreatedAccountContinueButton();
    }

    @Test(priority = 2)
    public void  verifyRegisteringAnAccountWithExistingEmailAddress() {
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("input-firstname")).sendKeys("Aleksandar");
        driver.findElement(By.id("input-lastname")).sendKeys("Georgievski");
        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
        driver.findElement(By.id("input-telephone")).sendKeys("077077077");
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
        driver.findElement(By.xpath("//input[@type='radio'][@value=0]")).click();
        driver.findElement(By.xpath("//input[@type='checkbox'][@name='agree']")).click();
        driver.findElement(By.xpath("//input[@type='submit'][@value='Continue']")).click();
        String warningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
        Assert.assertEquals(warningMessage, dataprop.getProperty("duplicateEmailWarning"), "Warning message is not displayed");
    }
}