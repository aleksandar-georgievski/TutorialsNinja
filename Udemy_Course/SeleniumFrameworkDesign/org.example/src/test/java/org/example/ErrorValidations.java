package org.example;

import TestComponents.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidations extends BaseTest {

    @Test
    public void submitOrder() throws IOException, InterruptedException {

        landingPage.loginApplication("ace.georgievsasdsadki1997@gmail.com", "Aleksandar1997");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

    }
}







