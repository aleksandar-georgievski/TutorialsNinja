package org.project.Tests;

import org.openqa.selenium.WebElement;
import org.project.PageObjects.CartPage;
import org.project.PageObjects.ProductCatalog;
import org.project.TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ErrorValidationsTest extends BaseTest {
    @Test(groups = "ErrorHandling")
    public void LoginErrorValidation() throws IOException, InterruptedException {
        landingPage.loginApplication("ace.georgievski2000@gmail.com", "test12345");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
    }

    @Test
    public void ProductErrorValidation() throws IOException, InterruptedException {
        String productName = "ZARA COAT 3";
        ProductCatalog productCatalog = landingPage.loginApplication("ace.georgievski1997@gmail.com", "test12345");
        productCatalog.goToOrdersPage();
    }
}














