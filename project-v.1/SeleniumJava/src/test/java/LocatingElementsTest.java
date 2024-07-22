import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class LocatingElementsTest {

    WebDriver driver;
    WebElement element;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void dropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        element = driver.findElement(By.id("dropdown"));
        element.click();
        WebElement option1 = element.findElement(By.cssSelector("option[value='1']"));
        WebElement option2 = element.findElement(By.cssSelector("option[value='2']"));
        option1.click();
        Assert.assertTrue(option1.isSelected());
        Assert.assertFalse(option2.isSelected());
    }

    @Test
    public void hover() {
        driver.get("https://the-internet.herokuapp.com/hovers");
        element = driver.findElement(By.className("figure"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        element = driver.findElement(By.xpath("//*[contains(text(), 'name: user1')]"));
        Assert.assertTrue("user1 should appear because we hovered over that image", element.isDisplayed());
    }

    @Test
    public void rightClick() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        element = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
        driver.switchTo().alert().accept();
    }

    @Test
    public void keyPresses() {
        driver.navigate().to("https://the-internet.herokuapp.com/key_presses");
        element = driver.findElement(By.id("target"));
        element.click();

        Actions actions = new Actions(driver);
        actions.
                sendKeys(Keys.ARROW_RIGHT).
                pause(1000).
                perform();
        element = driver.findElement(By.id("result"));
        Assert.assertEquals("Clicked right arrow key", "You entered: RIGHT", element.getText());
    }

    @Test
    public void getCSSValue() {
        driver.navigate().to("https://ultimateqa.com/simple-html-elements-for-automation/");
        element = driver.findElement(By.linkText("Clickable Icon"));
        String link = element.getAttribute("href");
        Assert.assertEquals("https://ultimateqa.com/link-success/", link);
    }

}

























