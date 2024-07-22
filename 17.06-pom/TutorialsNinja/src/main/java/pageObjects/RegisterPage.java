package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    WebDriver driver;
    public RegisterPage(WebDriver driver) {
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
    private WebElement confirmPasswordField;
    @FindBy(name = "agree")
    private WebElement selectAgreeOption;
    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;
    @FindBy(xpath = "//input[@name='newsletter'][@value='1']")
    private WebElement selectNewsletterOption;
    @FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
    private WebElement duplicateEmailWarningMessage;
    @FindBy(xpath = "//div[contains(@class, 'alert-dismissible')]")
    private WebElement privacyPolicyWarningText;
    @FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
    private WebElement firstNameWarningText;
    @FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
    private WebElement lastNameWarningText;
    @FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
    private WebElement emailWarningText;
    @FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
    private WebElement telephoneWarningText;
    @FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
    private WebElement passwordWarningText;

    public void enterFirstName(String firstNameText) {
        firstNameField.sendKeys(firstNameText);
    }
    public void enterLastName(String lastNameText) {
        lastNameField.sendKeys(lastNameText);
    }
    public void enterEmailAddress(String emailText) {
        emailField.sendKeys(emailText);
    }
    public void enterTelephoneNumber(String telephoneText) {
        telephoneField.sendKeys(telephoneText);
    }
    public void enterPassword(String passwordText) {
        passwordField.sendKeys(passwordText);
    }
    public void enterConfirmPassword(String passwordText) {
        confirmPasswordField.sendKeys(passwordText);
    }
    public void selectAgreeOption() {
        selectAgreeOption.click();
    }
    public AccountSuccessPage clickOnContinueButton() {
        continueButton.click();
        return new AccountSuccessPage(driver);
    }
    public void selectNewsletterOption() {
        selectNewsletterOption.click();
    }
    public String retrieveDuplicateEmailAddressWarning() {
        return duplicateEmailWarningMessage.getText();
    }
    public String retrievePrivacyPolicyWarningText() {
        return privacyPolicyWarningText.getText();
    }
    public String retrieveFirstNameWarningText() {
        return firstNameWarningText.getText();
    }
    public String retrieveLastNameWarningText() {
        return lastNameWarningText.getText();
    }
    public String retrieveEmailWarningText() {
        return emailWarningText.getText();
    }
    public String retrieveTelephoneWarningText() {
        return telephoneWarningText.getText();
    }
    public String retrievePasswordWarningText() {
        return passwordWarningText.getText();
    }

    public AccountSuccessPage registerWithMandatoryFields(String firstNameText, String lastNameText, String emailText, String telephoneText, String passwordText) {
        firstNameField.sendKeys(firstNameText);
        lastNameField.sendKeys(lastNameText);
        emailField.sendKeys(emailText);
        telephoneField.sendKeys(telephoneText);
        passwordField.sendKeys(passwordText);
        confirmPasswordField.sendKeys(passwordText);
        selectAgreeOption.click();
        continueButton.click();
        return new AccountSuccessPage(driver);
    }
    public AccountSuccessPage registerWithAllFields(String firstNameText, String lastNameText, String emailText, String telephoneText, String passwordText) {
        firstNameField.sendKeys(firstNameText);
        lastNameField.sendKeys(lastNameText);
        emailField.sendKeys(emailText);
        telephoneField.sendKeys(telephoneText);
        passwordField.sendKeys(passwordText);
        confirmPasswordField.sendKeys(passwordText);
        selectAgreeOption.click();
        selectNewsletterOption.click();
        continueButton.click();
        return new AccountSuccessPage(driver);
    }
    public boolean displayStatusOfWarningMessages(
            String expectedPrivacyPolicyWarning,
            String expectedFirstNameWarning,
            String expectedLastNameWarning,
            String expectedEmailWarning,
            String expectedTelephoneWarning,
            String expectedPasswordWarning
            ) {
        boolean privacyPolicyWarningStatus = privacyPolicyWarningText.getText().contains(expectedPrivacyPolicyWarning);
        boolean firstNameWarningStatus = firstNameWarningText.getText().contains(expectedFirstNameWarning);
        boolean lastNameWarningStatus = lastNameWarningText.getText().contains(expectedLastNameWarning);
        boolean emailWarningStatus = emailWarningText.getText().contains(expectedEmailWarning);
        boolean telephoneWarningStatus = telephoneWarningText.getText().contains(expectedTelephoneWarning);
        boolean passwordWarningStatus = passwordWarningText.getText().contains(expectedPasswordWarning);

        return privacyPolicyWarningStatus && firstNameWarningStatus && lastNameWarningStatus && emailWarningStatus && telephoneWarningStatus && passwordWarningStatus;
    }
}















