package TestCases;

import Pages.LoginPageFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class VerifyLoginPageFactory {

    @Test
    public void checkValidUser() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/index.html");

        LoginPageFactory login_page = PageFactory.initElements(driver, LoginPageFactory.class);
        login_page.login_page("standard_user", "secret_sauce");
    }
}
