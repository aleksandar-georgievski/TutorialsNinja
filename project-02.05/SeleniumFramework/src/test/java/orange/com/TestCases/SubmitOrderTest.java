package orange.com.TestCases;

import orange.com.PageObjects.*;
import orange.com.TestComponents.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class SubmitOrderTest extends BaseTest {
    @BeforeMethod
    public void setUp() throws IOException {
        initializeDriver();
    }

    @Test
    public void submitOrder() {
        String productName = "Sauce Labs Backpack";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openWebsiteUrl();
        loginPage.loginForm("standard_user", "secret_sauce");

        ProductPage productPage = new ProductPage(driver);
        Assert.assertEquals(productPage.getLandingPageTitle(), "Products");
        productPage.addItemToCart(productName);


        PickedProductPage pickedProductPage = new PickedProductPage(driver);
        Assert.assertEquals(pickedProductPage.getPickedProductTitle(), productName);
        pickedProductPage.addItemToCart();

        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getCartItemTitle(), productName);
        cartPage.clickCheckoutButton();

        //Checkout Page Step One
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.checkOutForm("Ace", "Georg", "1111");

        //Checkout Page Step Two
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        Assert.assertEquals(checkoutStepTwoPage.getCheckoutProductItemText(), productName);
        checkoutStepTwoPage.clickOnFinishButton();

        //Checkout Page Final
        CheckoutFinalPage checkoutFinalPage = new CheckoutFinalPage(driver);
        Assert.assertEquals(checkoutFinalPage.getCompletedOrderFinalMessage(), "THANK YOU FOR YOUR ORDER");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}


//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_container")));
//        List <WebElement>  containers = driver.findElements(By.cssSelector(".inventory_container"));
//        WebElement productTitle = containers.stream().flatMap(product ->
//                product.findElements(By.xpath("//div[@class='inventory_item_label']//a//div")).stream()).filter(item -> item.getText().equals(productName)).findFirst().orElse(null);
//        assert productTitle != null;
//        productTitle.click();