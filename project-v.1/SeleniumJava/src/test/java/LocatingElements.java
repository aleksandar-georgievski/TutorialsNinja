import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LocatingElements {
    @Test
    public void elementsQuiz1() {
//      System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.id("user-name"))
        );
        Assert.assertTrue(element.isDisplayed());
        driver.quit();
    }
}
