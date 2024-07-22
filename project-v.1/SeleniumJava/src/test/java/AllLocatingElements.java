import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AllLocatingElements {
    @Test
    public void typesOfLocators() {
        //1. Instantiate the driver
        WebDriver driver = new FirefoxDriver();
        //2. Navigate to the url
        driver.get("https://www.saucedemo.com/v1/index.html");
        //3. Find element
        WebElement element;
        //ID
        element = driver.findElement(By.id("user-name"));
        //Class name
        driver.findElement(By.className("form_input"));
        //Tag name
        driver.findElement(By.tagName("input"));
        //CSS selector
        driver.findElement(By.cssSelector("#user-name"));
        //Xpath
        driver.findElement(By.xpath("//*[@id='user-name']"));
        //Partial link text
//        driver.findElement(By.partialLinkText("this is partial link text!"));

        //4. Quit the driver
        driver.quit();
    }
}
