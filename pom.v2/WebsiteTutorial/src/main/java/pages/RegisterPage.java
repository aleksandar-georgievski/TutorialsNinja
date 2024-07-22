package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver driver;

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

    @FindBy(xpath = "//input[@type='radio'][@value=0]")
    private WebElement subscribeButton;

    @FindBy(xpath = "//input[@type='checkbox'][@name='agree']")
    private WebElement privacyPolicyField;

    @FindBy(xpath = "//input[@type='submit'][@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@id='content']//h1")
    private WebElement successHeadingText;

    @FindBy(xpath = "//a[contains(text(), 'Continue')]")
    private WebElement createdAccountContinueButton;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterFirstName(String firstNameText) {
        firstNameField.sendKeys(firstNameText);
    }
    public void enterLastName(String lastNameText) {
        lastNameField.sendKeys(lastNameText);
    }
    public void enterEmail(String emailText) {
        emailField.sendKeys(emailText);
    }
    public void enterTelephone(String telephoneText) {
        telephoneField.sendKeys(telephoneText);
    }
    public void enterPassword(String passwordText) {
        passwordField.sendKeys(passwordText);
    }
    public void enterConfirmPassword(String confirmPasswordText) {
        confirmPasswordField.sendKeys(confirmPasswordText);
    }
    public void clickSubscribeButton() {
        subscribeButton.click();
    }
    public void clickPrivacyPolicyField() {
        privacyPolicyField.click();
    }
    public void clickContinueButton() {
        continueButton.click();
    }
    public String getSuccessHeadingText() {
        String successText = successHeadingText.getText();
        return successText;
    }
    public void getCreatedAccountContinueButton() {
        createdAccountContinueButton.click();
    }
}













