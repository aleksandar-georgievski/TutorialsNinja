package testcases;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import static utils.Utilities.generateEmailWithTimeStamp;

public class LoginPOTest extends Base {
    public WebDriver driver;
    LoginPage loginPage;
    public LoginPOTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
        HomePage homePage = new HomePage(driver);
        loginPage = homePage.navigateToLoginPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void verifyLoginWithValidCredentials() {
        AccountPage accountPage = loginPage.login(prop.getProperty("validEmail"),prop.getProperty("validPassword"));
        Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption(), "Edit your account information option is not displayed");
    }

    @Test(priority = 2)
    public void verifyLoginWithInvalidCredentials() {
        loginPage.login(generateEmailWithTimeStamp(),dataProp.getProperty("invalidPassword"));
        Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")), "Expected warning message is not displayed");
    }

    @Test(priority = 3)
    public void verifyLoginWithInvalidEmailAndValidPassword() {
        loginPage.login(generateEmailWithTimeStamp(),prop.getProperty("validPassword"));
        Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")), "Expected warning message is not displayed");
    }

    @Test(priority = 4)
    public void verifyLoginWithValidEmailAndInvalidPassword() {
        loginPage.login(prop.getProperty("validEmail"),dataProp.getProperty("invalidPassword"));
        Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")), "Expected warning message is not displayed");
    }

    @Test(priority = 5)
    public void verifyLoginWithoutProvidingCredentials() {
        loginPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingText().contains(dataProp.getProperty("emailPasswordNoMatchWarning")), "Expected warning message is not displayed");
    }
    @Test(priority = 6)

    public void verifyForgottenPasswordIsDisplayedInLoginPage() {
        Assert.assertEquals(loginPage.retrieveForgottenPasswordText(), "Forgotten Password", "Forgotten Password Link is not displayed");
    }

    @Test(priority = 7)
    public void verifyPlaceholderText() {
        Assert.assertTrue(loginPage.getEmailPlaceholderText().contains("E-Mail Address"));
        Assert.assertEquals(loginPage.getPasswordPlaceholderText(), "Password");
    }
}




//    @DataProvider(name = "validCredentialsSupplier")
//    public Object[][] supplyTestData() {
//        Object[][] data = Utilities.getTestDataFromExcel("LoginPO");
//        return data;
//    }
//
//    @Test(priority = 1, dataProvider = "validCredentialsSupplier")
//    public void verifyLoginWithValidCredentials(String email, String password) {
//        loginPage.enterEmailAddress(email);
//        loginPage.enterPassword(password);
//        AccountPage accountPage = loginPage.clickOnLoginButton();
//        Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption(), "Edit your account information option is not displayed");
//    }










