package org.example.tests;

import org.example.TestComponents.BaseTest;
import org.example.tests.pageobjects.CartPage;
import org.example.tests.pageobjects.ProductCatalog;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidations extends BaseTest {
    @Test
    public void LoginErrorValidation() throws IOException, InterruptedException {
        ProductCatalog productCatalog = landingPage.loginApplication("ace.1997@gmail.com", "Acika.1997");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
    }

    @Test
    public void ProductErrorValidations() throws InterruptedException {
        String productName = "ZARA COAT 3";
        ProductCatalog productCatalog = landingPage.loginApplication("ace.georgievski1997@gmail.com", "Acika.1997");
        productCatalog.addProductToCart(productName);
        CartPage cartPage = productCatalog.goToCartPage();

        Boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
        Assert.assertFalse(match);
    }
}