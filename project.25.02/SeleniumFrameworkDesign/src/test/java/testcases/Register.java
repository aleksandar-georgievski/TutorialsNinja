package testcases;

import base.Base;
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

    public Register() {
        super();
    }

    WebDriver driver;
    RegisterPage registerPage;
    AccountSuccessPage accountSuccessPage;

    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
        HomePage homePage = new HomePage(driver);
//        homePage.clickOnMyAccount();
//        registerPage = homePage.selectRegisterOption();
        registerPage = homePage.navigateToRegisterPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void verifyRegisteringAnAccountWithAllFields() {
//        registerPage.enterFirstName(dataProp.getProperty("firstName"));
//        registerPage.enterLastName(dataProp.getProperty("lastName"));
//        registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
//        registerPage.enterTelephone(dataProp.getProperty("telephoneNumber"));
//        registerPage.enterPassword(prop.getProperty("validPassword"));
//        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//        registerPage.selectPrivacyPolicy();
//        accountSuccessPage = registerPage.clickOnContinueButton();
        accountSuccessPage = registerPage.registerWithAllFields(
                dataProp.getProperty("firstName"),
                dataProp.getProperty("lastName"),
                Utilities.generateEmailWithTimeStamp(),
                dataProp.getProperty("telephoneNumber"),
                prop.getProperty("validPassword")
        );

//        String actualSuccessHeading = accountSuccessPage.retrieveAccountSuccessPageHeading();
//        Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success page is not displayed");;
        Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(), dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success page is not displayed");;
    }

    @Test(priority = 2)
    public void verifyRegisteringAccountByProvidingAllFields() {
//        registerPage.enterFirstName(dataProp.getProperty("firstName"));
//        registerPage.enterLastName(dataProp.getProperty("lastName"));
//        registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
//        registerPage.enterTelephone(dataProp.getProperty("telephoneNumber"));
//        registerPage.enterPassword(prop.getProperty("validPassword"));
//        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//        registerPage.selectYesNewsletterOption();
//        registerPage.selectPrivacyPolicy();
//        accountSuccessPage = registerPage.clickOnContinueButton();
        accountSuccessPage = registerPage.registerWithAllFields(
                dataProp.getProperty("firstName"),
                dataProp.getProperty("lastName"),
                Utilities.generateEmailWithTimeStamp(),
                dataProp.getProperty("telephoneNumber"),
                prop.getProperty("validPassword")
        );

//        String actualSuccessHeading = accountSuccessPage.retrieveAccountSuccessPageHeading();
//        Assert.assertEquals(actualSuccessHeading, dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success page is not displayed");;
        Assert.assertEquals(accountSuccessPage.retrieveAccountSuccessPageHeading(), dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success page is not displayed");;
    }

    @Test(priority = 3)
    public void verifyRegisteringAccountWithExistingEmailAddress() {
//        registerPage.enterFirstName(dataProp.getProperty("firstName"));
//        registerPage.enterLastName(dataProp.getProperty("lastName"));
//        registerPage.enterEmailAddress(prop.getProperty("validEmail"));
//        registerPage.enterTelephone(dataProp.getProperty("telephoneNumber"));
//        registerPage.enterPassword(prop.getProperty("validPassword"));
//        registerPage.enterConfirmPassword(prop.getProperty("validPassword"));
//        registerPage.selectYesNewsletterOption();
//        registerPage.selectPrivacyPolicy();
//        accountSuccessPage = registerPage.clickOnContinueButton();
        registerPage.registerWithAllFields(
                dataProp.getProperty("firstName"),
                dataProp.getProperty("lastName"),
                prop.getProperty("validEmail"),
                dataProp.getProperty("telephoneNumber"),
                prop.getProperty("validPassword")

        );

//        String actualWarning = registerPage.retrieveDuplicateEmailAddressWarningText();
//        Assert.assertTrue(actualWarning.contains(dataProp.getProperty("duplicateEmailWarning")), "Warning message is not displayed.");
        Assert.assertTrue(registerPage.retrieveDuplicateEmailAddressWarningText().contains(dataProp.getProperty("duplicateEmailWarning")), "Account Success page is not displayed");;
    }

    @Test(priority = 4)
    public void verifyRegisteringAccountWithoutFillingAnyDetails() {
         registerPage.clickOnContinueButton();

//        String actualPrivacyPolicyWarning = registerPage.retrievePrivacyPolicyWarningText();
//        Assert.assertTrue(actualPrivacyPolicyWarning.contains(dataProp.getProperty("privacyPolicyWarning")), "Privacy Policy warning message is not displayed");
//
//        String actualFirstNameWarning = registerPage.retrieveFirstNameWarningText();
//        Assert.assertTrue(actualFirstNameWarning.contains(dataProp.getProperty("firstNameWarning")), "First Name warning message is not displayed");
//
//        String actualLastNameWarning = registerPage.retrieveLastNameWarningText();
//        Assert.assertTrue(actualLastNameWarning.contains(dataProp.getProperty("lastNameWarning")), "Last Name warning message is not displayed");
//
//        String actualEmailWarning = registerPage.retrieveEmailWarningText();
//        Assert.assertTrue(actualEmailWarning.contains(dataProp.getProperty("emailWarning")), "Email warning message is not displayed");
//
//        String actualTelephoneWarning = registerPage.retrieveTelephoneWarningText();
//        Assert.assertTrue(actualTelephoneWarning.contains(dataProp.getProperty("telephoneWarning")), "Telephone warning message is not displayed");
//
//        String actualPasswordWarning = registerPage.retrievePasswordWarningText();
//        Assert.assertTrue(actualPasswordWarning.contains(dataProp.getProperty("passwordWarning")), "Password warning message is not displayed");
        /// NEW PART
//        Assert.assertTrue(registerPage.retrievePrivacyPolicyWarningText().contains(dataProp.getProperty("privacyPolicyWarning")), "Privacy Policy warning message is not displayed");
//
//        Assert.assertTrue(registerPage.retrieveFirstNameWarningText().contains(dataProp.getProperty("firstNameWarning")), "First Name warning message is not displayed");
//
//        Assert.assertTrue(registerPage.retrieveLastNameWarningText().contains(dataProp.getProperty("lastNameWarning")), "Last Name warning message is not displayed");
//
//        Assert.assertTrue(registerPage.retrieveEmailWarningText().contains(dataProp.getProperty("emailWarning")), "Email warning message is not displayed");
//
//        Assert.assertTrue(registerPage.retrieveTelephoneWarningText().contains(dataProp.getProperty("telephoneWarning")), "Telephone warning message is not displayed");
//
//        Assert.assertTrue(registerPage.retrievePasswordWarningText().contains(dataProp.getProperty("passwordWarning")), "Password warning message is not displayed");

        Assert.assertTrue(registerPage.displayStatusOfWarningMessages(
                dataProp.getProperty("privacyPolicyWarning"),
                dataProp.getProperty("firstNameWarning"),
                dataProp.getProperty("lastNameWarning"),
                dataProp.getProperty("emailWarning"),
                dataProp.getProperty("telephoneWarning"),
                dataProp.getProperty("passwordWarning")
        ), "Warning Messages are not displayed");
    }
}










