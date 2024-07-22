package testcases;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.AccountSuccessPage;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

import static utils.Utilities.generateEmailWithTimeStamp;

public class RegisterPOTest extends Base {
    public WebDriver driver;
    RegisterPage registerPage;
    AccountSuccessPage accountSuccessPage;

    public RegisterPOTest() {
        super();
    }
    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
        HomePage homePage = new HomePage(driver);
        registerPage = homePage.navigateToRegisterPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test(priority = 1)
    public void verifyRegisteringAnAccountWithMandatoryFields() {
         accountSuccessPage = registerPage.registerWithMandatoryFields(
                dataProp.getProperty("firstName"),
                dataProp.getProperty("lastName"),
                generateEmailWithTimeStamp(),
                dataProp.getProperty("telephoneNumber"),
                prop.getProperty("validPassword")
        );
        Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(), dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success Page is not displayed");
    }

    @Test(priority = 2)
    public void verifyRegisteringAccountByProvidingAllFields() {
        accountSuccessPage = registerPage.registerWithAllFields(
                dataProp.getProperty("firstName"),
                dataProp.getProperty("lastName"),
                generateEmailWithTimeStamp(),
                dataProp.getProperty("telephoneNumber"),
                prop.getProperty("validPassword")
        );
        Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(), dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success Page is not displayed");
    }

    @Test(priority = 3)
    public void verifyRegisteringAccountWithExistingEmailAddress() {
        accountSuccessPage = registerPage.registerWithAllFields(
                dataProp.getProperty("firstName"),
                dataProp.getProperty("lastName"),
                prop.getProperty("validEmail"),
                dataProp.getProperty("telephoneNumber"),
                prop.getProperty("validPassword")
        );
        Assert.assertTrue(registerPage.retrieveDuplicateEmailAddressWarning().contains(dataProp.getProperty("duplicateEmailWarning")), "Warning message is not displayed");
    }

    @Test(priority = 4)
    public void verifyRegisteringAccountWithoutFillingAnyDetails() {
        registerPage.clickOnContinueButton();

        Assert.assertTrue(registerPage.displayStatusOfWarningMessages(
                dataProp.getProperty("privacyPolicyWarning"),
                dataProp.getProperty("firstNameWarning"),
                dataProp.getProperty("lastNameWarning"),
                dataProp.getProperty("emailWarning"),
                dataProp.getProperty("telephoneWarning"),
                dataProp.getProperty("passwordWarning")
        ));

//        Assert.assertTrue(registerPage.retrievePrivacyPolicyWarningText().contains(dataProp.getProperty("privacyPolicyWarning")), "Privacy Policy Warning message is not displayed");
//        Assert.assertEquals(registerPage.retrieveFirstNameWarningText(), dataProp.getProperty("firstNameWarning"), "First Name Warning message is not displayed");
//        Assert.assertEquals(registerPage.retrieveLastNameWarningText(), dataProp.getProperty("lastNameWarning"), "Last Name Warning message is not displayed");
//        Assert.assertEquals(registerPage.retrieveEmailWarningText(), dataProp.getProperty("emailWarning"), "Email Warning message is not displayed");
//        Assert.assertEquals(registerPage.retrieveTelephoneWarningText(), dataProp.getProperty("telephoneWarning"), "Telephone Warning message is not displayed");
//        Assert.assertEquals(registerPage.retrievePasswordWarningText(), dataProp.getProperty("passwordWarning"), "Password Warning message is not displayed");
    }
}
























