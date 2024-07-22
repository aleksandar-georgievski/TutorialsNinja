package com.tests;

import com.TestComponents.BaseTest;
import com.pageobjects.CartPage;
import com.pageobjects.ProductCatalog;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidationsTest extends BaseTest {

    @Test(groups = {"ErrorHandling"})
    public void LoginErrorValidation() throws IOException {

        landingPage.loginApplication("ace.georgievski@gmail.com", "test123");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
    }

    @Test
    public void ProductErrorValidation() throws IOException {

        String productName = "ZARA COAT 3";
        ProductCatalog productCatalog = landingPage.loginApplication("ace.georgievski1997@gmail.com", "test12345");
        productCatalog.addProductToCart(productName);
        CartPage cartPage = productCatalog.goToCartPage();
        boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(match);
    }
}














