package org.example.tests.pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractComponent {

    WebDriver driver;

    public OrderPage(WebDriver driver) {
        super(driver);
        //initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".totalRow button")
    WebElement checkoutElement;
    @FindBy(css = ".cartSection h3")
    List<WebElement> cartProducts;

    public Boolean verifyProductDisplay(String productName) {
        return cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
    }
}
