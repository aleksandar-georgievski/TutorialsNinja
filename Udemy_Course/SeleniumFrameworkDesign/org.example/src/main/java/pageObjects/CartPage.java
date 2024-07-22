package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver driver;

    @FindBy(css = ".totalRow button")
    WebElement checkoutElement;
    @FindBy(xpath = "//*[@class='cartSection']/h3")
    List <WebElement> productTitles;

    public CartPage(WebDriver driver) {
        super(driver);
        // initialization of driver
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    By cartProductsBy = By.xpath("//*[@class='cartSection']/h3");

    public Boolean VerifyProductDisplay(String productName) {
        Boolean match = productTitles.stream().anyMatch(cartProduct ->
                cartProduct.getText().equalsIgnoreCase(productName));
        return match;
    }

    public CheckOutPage goToCheckout() {
        checkoutElement.click();
        return new CheckOutPage(driver);
    }



}




















