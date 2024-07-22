import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Browser2Test {
    @Test
    public void firstTest()
    {
        System.setProperty("webdriver.chrome.driver", "resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.quit();
    }
}
