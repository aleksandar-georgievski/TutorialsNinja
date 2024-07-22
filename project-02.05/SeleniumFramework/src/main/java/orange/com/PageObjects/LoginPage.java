package orange.com.PageObjects;

import orange.com.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponent {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement userName;
    @FindBy(id = "password")
    WebElement userPassword;
    @FindBy(id = "login-button")
    WebElement loginButton;

    public void openWebsiteUrl() {
        driver.get("https://www.saucedemo.com/v1/index.html");
    }

    public void loginForm(String userNameText, String userPasswordText) {
        userName.sendKeys(userNameText);
        userPassword.sendKeys(userPasswordText);
        loginButton.click();
    }
}
