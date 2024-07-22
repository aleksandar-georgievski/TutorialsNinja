package pages;

import org.openqa.selenium.By;
import utility.BrowserDriver;

public class LoginPage extends BrowserDriver {
    public static String username_text_id = "usr";
    public static String password_text_id = "pwd";
    public static String login_button_xpath = "//input[@type='submit']";
    public static String newRegister_button_id = "NewRegistration";


    public static void sendKeys_username() {
        driver.findElement(By.id(username_text_id)).sendKeys("Scott.gale@gmail.com");

    }
    public static void sendKeys_password() {
        driver.findElement(By.id(password_text_id)).sendKeys("P@sword!");
    }
    public static void click_login_button() {
        driver.findElement(By.xpath(login_button_xpath)).click();
    }
    public static void click_newRegister_button() {
        driver.findElement(By.id(newRegister_button_id)).click();
    }
}
