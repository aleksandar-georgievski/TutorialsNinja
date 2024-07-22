package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageFactory {

    WebDriver driver;

    public LoginPageFactory(WebDriver ldriver) {
        this.driver = ldriver;
    }
    @FindBy(id = "user-name") WebElement usernameField;

    @FindBy(how = How.ID,using = "password") WebElement passwordField;

    @FindBy(how = How.XPATH,using = "//input[@id='login-button']") WebElement submit_button;

    public void login_page(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submit_button.click();
    }

}
