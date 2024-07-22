import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloSelenium2Test {

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void smarterTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

//    @BeforeClass
//    public static void setupClass() {
//        WebDriverManager.chromedriver().setup();
//    }
//    @Test
//    public void smarterTest() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.saucedemo.com/v1/index.html");
//        driver.quit();
//    }
}
