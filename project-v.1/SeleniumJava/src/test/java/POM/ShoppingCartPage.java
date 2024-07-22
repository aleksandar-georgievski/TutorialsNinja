package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
    private WebDriver driver;
    private WebElement getCheckoutButton() {
        return driver.findElement(By.id("FAKE LOCATOR"));
    }
    public void startCheckout() {
        getCheckoutButton().click();
    }
}
