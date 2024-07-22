package org.project.Tests;

import org.openqa.selenium.WebElement;
import org.project.PageObjects.*;
import org.project.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CompleteTest extends BaseTest {
    String productName = "ZARA COAT 3";
    @Test(dataProvider = "getData")
    public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {
        ProductCatalog productCatalog = landingPage.loginApplication(input.get("email"), input.get("password"));
        List <WebElement> products = productCatalog.getProductList();
        productCatalog.addProductToCart(input.get("product"));
        CartPage cartPage = productCatalog.goToCartPage();

        boolean match = cartPage.verifyProductDisplay(input.get("product"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
    }

    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistory() {
        ProductCatalog productCatalog = landingPage.loginApplication("ace.georgievski1997@gmail.com", "test12345");
        OrderPage orderPage = productCatalog.goToOrdersPage();
        Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
//        HashMap <String,String> map = new HashMap<>();
//        map.put("email", "ace.georgievski1997@gmail.com");
//        map.put("password", "test12345");
//        map.put("product", "ZARA COAT 3");
//
//        HashMap <String,String> map1 = new HashMap<>();
//        map1.put("email", "ace.georgievski1997@gmail.com");
//        map1.put("password", "test12345");
//        map1.put("product", "ADIDAS ORIGINAL");
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\data\\PurchaseOrder.json");
        return new Object[][]{{data.get(0)}, {data.get(1)}};
    }
}














