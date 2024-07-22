package com.tests;

import com.TestComponents.BaseTest;
import com.pageobjects.*;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {
    String productName = "ZARA COAT 3";
    @Test(dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(HashMap<String,String> input) throws IOException {
        ProductCatalog productCatalog = landingPage.loginApplication(input.get("email"), input.get("password"));
        productCatalog.addProductToCart(input.get("product"));
        CartPage cartPage = productCatalog.goToCartPage();
        boolean match = cartPage.verifyProductDisplay(input.get("product"));
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("india");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();

        String confirmMessage = confirmationPage.getConfirmMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
    }

    //To verify ZARA COAT 3 is displaying in orders page
    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistoryTest() {
        ProductCatalog productCatalog = landingPage.loginApplication("ace.georgievski1997@gmail.com", "test12345");
        OrderPage orderPage = productCatalog.goToOrdersPage();
        Assert.assertTrue(orderPage.verifyOrderDisplay(productName));
    }

    @DataProvider
    public Object[][] getData() throws IOException {
//        HashMap<String,String> map = new HashMap<String,String>();
//        map.put("email", "ace.georgievski1997@gmail.com");
//        map.put("password", "test12345");
//        map.put("product", "ZARA COAT 3");
//
//        HashMap<String,String> map1 = new HashMap<String,String>();
//        map1.put("email", "ace.georgievski@gmail.com");
//        map1.put("password", "Test12345");
//        map1.put("product", "ADIDAS ORIGINAL");
//        return new Object[][]{{map},{map1}};
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//com//data//PurchaseOrder.json");
        return new Object[][] {{data.get(0)}, {data.get(1)}};
    }
}














