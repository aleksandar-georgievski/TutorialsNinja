package testcases;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.Utilities;

public class Login extends Base {

    public Login() {
        super();
    }

    WebDriver driver;
    LoginPage loginPage;
    AccountPage accountPage;

    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
        HomePage homePage = new HomePage(driver);
//        homePage.clickOnMyAccount();
//        loginPage = homePage.selectLoginOption();
        loginPage = homePage.navigateToLoginPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1, dataProvider = "validCredentialsSupplier")
    public void verifyLoginWithValidCredentials(String email, String password) {
//        loginPage.enterEmailAddress(email);
//        loginPage.enterPassword(password);
//        accountPage = loginPage.clickOnLoginButton();
        accountPage = loginPage.login(email, password);

        Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption(), "Edit your account information option is not displayed");
    }

    @DataProvider(name = "validCredentialsSupplier")
    public Object[][] supplyTestData() {
        Object[][] data = Utilities.getTestDataFromExcel("Login");
        return data;
    }


    @Test(priority = 2)
    public void verifyLoginWithInvalidCredentials() {
//        loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
//        loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
//        loginPage.clickOnLoginButton();
        accountPage = loginPage.login(Utilities.generateEmailWithTimeStamp(),dataProp.getProperty("invalidPassword"));

//        String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
//        String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarningMessage");
//        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
        Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarningMessage")), "Expected Warning message is not displayed");
    }

    @Test(priority = 3)
    public void verifyLoginWithInvalidEmailAndValidPassword() {
//        loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
//        loginPage.enterPassword(prop.getProperty("validPassword"));
//        loginPage.clickOnLoginButton();
        accountPage = loginPage.login(Utilities.generateEmailWithTimeStamp(),prop.getProperty("validPassword"));

//        String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
//        String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarningMessage");
        Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarningMessage")), "Expected Warning message is not displayed");
    }

    @Test(priority = 4)
    public void verifyLoginWithValidEmailAndInvalidPassword() {
//        loginPage.enterEmailAddress(prop.getProperty("validEmail"));
//        loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
//        loginPage.clickOnLoginButton();
        accountPage = loginPage.login(prop.getProperty("validEmail"),dataProp.getProperty("invalidPassword"));

//        String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
//        String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarningMessage");
        Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarningMessage")), "Expected Warning message is not displayed");
    }

    @Test(priority = 5)
    public void verifyLoginWithoutProvidingCredentials() {
        loginPage.clickOnLoginButton();

//        String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
//        String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchWarningMessage");
        Assert.assertTrue(loginPage.retrieveEmailPasswordNotMatchingWarningMessageText().contains(dataProp.getProperty("emailPasswordNoMatchWarningMessage")), "Expected Warning message is not displayed");
    }
}















