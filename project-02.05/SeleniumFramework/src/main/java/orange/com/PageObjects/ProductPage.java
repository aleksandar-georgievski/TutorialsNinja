package orange.com.PageObjects;

import orange.com.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends AbstractComponent {
    WebDriver driver;
    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    By getInventoryItemText = By.cssSelector(".inventory_item .inventory_item_label a");
    By clickOnItemLinkText = By.cssSelector(".inventory_item_name");
    @FindBy(css = ".inventory_item")
    List <WebElement> inventoryItemsList;
    @FindBy(css = ".product_label")
    WebElement landingPageTitle;

    public WebElement getInventoryItemsList(String productName) {
        WebElement productTitle = inventoryItemsList.stream().filter(product ->
                product.findElement(getInventoryItemText).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
        assert productTitle != null;
        return productTitle;
    }
    public void addItemToCart(String productName) {
        WebElement item = getInventoryItemsList(productName);
        item.findElement(clickOnItemLinkText).click();
    }
    public String getLandingPageTitle() {
        return  landingPageTitle.getText();
    }
}
