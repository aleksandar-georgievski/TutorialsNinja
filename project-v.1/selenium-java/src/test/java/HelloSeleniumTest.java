import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSeleniumTest {
    public void firstTest() {
        // The path of chromedriver for windows
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        // Create a new chrome driver for us to use to automate Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.quit();
    }
}
