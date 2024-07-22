package org.project.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.project.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement userEmail;
    @FindBy(id = "userPassword")
    WebElement userPassword;
    @FindBy(id = "login")
    WebElement loginButton;
    @FindBy(css = "[class*='flyInOut']")
    WebElement errorMessage;
    public ProductCatalog loginApplication(String email, String password) {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        loginButton.click();
        return new ProductCatalog(driver);
    }
    public String getErrorMessage() {
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }
    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client/");
    }
}




























