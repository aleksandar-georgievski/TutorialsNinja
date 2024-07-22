package Pages;


import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// This class will store all the locators and methods of Login Page
public class LoginPage {

    WebDriver driver;

    By usernameInput = By.xpath("//input[@name='user-name']");
    By passwordInput = By.xpath("//input[@type='password']");
    By loginButton = By.className("btn_action");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void usernameInput(String username) {
       driver.findElement(usernameInput).sendKeys(username);
    }
    public void passwordInput(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
