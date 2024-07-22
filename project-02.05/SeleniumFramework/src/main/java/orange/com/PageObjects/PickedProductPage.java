package orange.com.PageObjects;

import orange.com.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PickedProductPage extends AbstractComponent {
    WebDriver driver;
    public PickedProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn_inventory")
    WebElement addToCartButton;
    @FindBy(id = "shopping_cart_container")
    WebElement clickOnCartIcon;
    @FindBy(css = ".inventory_details_name")
    WebElement pickedProductTitle;

    public void addItemToCart() {
        addToCartButton.click();
        clickOnCartIcon.click();
    }
    public String getPickedProductTitle() {
        return pickedProductTitle.getText();
    }
}
