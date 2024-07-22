import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alerts {
    WebDriver driver;
    WebElement element;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
    }
    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void alerts() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//*[contains(normalize-space(text()), 'Click for JS Alert')]")).click();
        driver.switchTo().alert().dismiss();

        driver.findElement(By.xpath("//*[contains(normalize-space(text()), 'Click for JS Confirm')]")).click();
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//*[contains(normalize-space(text()), 'Click for JS Prompt')]")).click();
        Alert inputAlert = driver.switchTo().alert();
        String text = inputAlert.getText();
        inputAlert.sendKeys("Look Mom! I can automate alerts :)");
    }
}
