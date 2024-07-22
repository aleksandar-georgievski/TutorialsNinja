package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FacebookPage {
    WebDriver driver;

    public FacebookPage(WebDriver driver) {
        this.driver = driver;
    }

    By Email_input = By.id("email");
    By Password_input = By.id("pass");
    By Login_Button = By.name("login");

    public void EnterEmail(String email_input) {
        driver.findElement(Email_input).clear();
        driver.findElement(Email_input).sendKeys(email_input);
    }

    public void EnterPassword(String password_input) {
        driver.findElement(Password_input).clear();
        driver.findElement(Password_input).sendKeys(password_input);
    }

    public void ClickLoginButton() {
        driver.findElement(Login_Button).click();
        WebElement title = driver.findElement(By.xpath("//span[contains(text(), 'Ace Georgievski')]"));
        Assert.assertTrue(true, title.getText());
    }
}
