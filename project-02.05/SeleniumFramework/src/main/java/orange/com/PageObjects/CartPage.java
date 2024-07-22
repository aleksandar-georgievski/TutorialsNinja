package orange.com.PageObjects;

import orange.com.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractComponent {
    WebDriver driver;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = ".checkout_button")
    WebElement clickOnCheckOutButton;
    @FindBy(css = ".cart_list .inventory_item_name")
    WebElement cartItemTitle;

    public void clickCheckoutButton() {
        clickOnCheckOutButton.click();
    }
    public String getCartItemTitle() {
        return cartItemTitle.getText();
    }
}
