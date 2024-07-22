import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

// This class represents a page object linked to https://www.saucedemo.com/
public class InventoryPage {
    private final WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }
    // Storing the sauce labs backpack in a method
    private WebElement sauceLabsBackPack() {
        return new FirefoxDriver().findElement(By.className(""));
    }

    public void addToCart(SauceItem item) {
        // Logic to add the appropriate item to the cart
        new FirefoxDriver().findElement(item).click();
    }

    public void goToCart() {

        //new FirefoxDriver().findElement("shopping cart").click();
    }
}
