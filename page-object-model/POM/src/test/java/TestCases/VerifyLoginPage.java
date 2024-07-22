package TestCases;

import Pages.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyLoginPage {
    @Test
    public void verifyValidLogin() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/index.html");
        LoginPage login = new LoginPage(driver);
        login.usernameInput("standard_user");
        login.passwordInput("secret_sauce");
        login.clickLoginButton();

        driver.quit();
    }
}
