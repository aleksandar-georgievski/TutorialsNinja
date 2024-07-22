package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameField;
    @FindBy(id = "input-lastname")
    private WebElement lastNameField;
    @FindBy(id = "input-email")
    private WebElement emailField;
    @FindBy(id = "input-telephone")
    private WebElement telephoneField;
    @FindBy(id = "input-password")
    private WebElement passwordField;
    @FindBy(id = "input-confirm")
    private WebElement passwordConfirmField;
    @FindBy(name = "agree")
    private WebElement privacyPolicyField;
    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//input[@name='newsletter'][@value='1']")
    private WebElement yesNewsletterOption;
    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    private WebElement duplicateEmailAddressWarning;
    @FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
    private WebElement privacyPolicyWarning;
    @FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
    private WebElement firstNameWarning;
    @FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
    private WebElement lastNameWarning;
    @FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
    private WebElement emailWarning;
    @FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
    private WebElement telephoneWarning;
    @FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
    private WebElement passwordWarning;

    public void enterFirstName(String firstNameText) {
        firstNameField.sendKeys(firstNameText);
    }
    public void enterLastName(String lastNameText) {
        lastNameField.sendKeys(lastNameText);
    }
    public void enterEmailAddress(String emailText) {
        emailField.sendKeys(emailText);
    }
    public void enterTelephone(String telephoneText) {
        telephoneField.sendKeys(telephoneText);
    }
    public void enterPassword(String passwordText) {
        passwordField.sendKeys(passwordText);
    }
    public void enterConfirmPassword(String confirmPasswordText) {
        passwordConfirmField.sendKeys(confirmPasswordText);
    }
    public void selectPrivacyPolicy() {
        privacyPolicyField.click();
    }
    public AccountSuccessPage clickOnContinueButton() {
        continueButton.click();
        return new AccountSuccessPage(driver);
    }
    public void selectYesNewsletterOption() {
        yesNewsletterOption.click();
    }
    public String retrieveDuplicateEmailAddressWarningText() {
        return duplicateEmailAddressWarning.getText();
    }
    public String retrievePrivacyPolicyWarningText() {
        return privacyPolicyWarning.getText();
    }
    public String retrieveFirstNameWarningText() {
        return firstNameWarning.getText();
    }
    public String retrieveLastNameWarningText() {
        return lastNameWarning.getText();
    }
    public String retrieveEmailWarningText() {
        return emailWarning.getText();
    }
    public String retrieveTelephoneWarningText() {
        return telephoneWarning.getText();
    }
    public String retrievePasswordWarningText() {
        return passwordWarning.getText();
    }

    public AccountSuccessPage registerWithAllFields(String firstNameText, String lastNameText, String emailText, String telephoneText, String passwordText) {
        firstNameField.sendKeys(firstNameText);
        lastNameField.sendKeys(lastNameText);
        emailField.sendKeys(emailText);
        telephoneField.sendKeys(telephoneText);
        passwordField.sendKeys(passwordText);
        passwordConfirmField.sendKeys(passwordText);
        yesNewsletterOption.click();
        privacyPolicyField.click();
        continueButton.click();
        return new AccountSuccessPage(driver);
    }

    public boolean displayStatusOfWarningMessages(
            String expectedPrivacyPolicyWarning,
            String expectedFirstNameWarning,
            String expectedLastNameWarning,
            String expectedEmailWarning,
            String expectedTelephoneWarning,
            String expectedPasswordWarning) {
        boolean privacyPolicyWarningStatus = privacyPolicyWarning.getText().contains(expectedPrivacyPolicyWarning);

        boolean firstNameWarningStatus = firstNameWarning.getText().equals(expectedFirstNameWarning);

        boolean lastNameWarningStatus = lastNameWarning.getText().equals(expectedLastNameWarning);

        boolean emailWarningStatus = emailWarning.getText().equals(expectedEmailWarning);

        boolean telephoneWarningStatus = telephoneWarning.getText().equals(expectedTelephoneWarning);

        boolean passwordWarningStatus = passwordWarning.getText().equals(expectedPasswordWarning);

        return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && telephoneWarningStatus && passwordWarningStatus;
    }

}


























