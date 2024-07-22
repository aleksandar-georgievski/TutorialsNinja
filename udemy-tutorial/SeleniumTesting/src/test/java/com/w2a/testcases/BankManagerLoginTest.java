package com.w2a.testcases;

import com.w2a.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BankManagerLoginTest extends TestBase {

    @Test
    public void loginAsBankManager() throws InterruptedException {
        driver.findElement(By.cssSelector(objectrepo.getProperty("bankManagerLoginButton"))).click();
//        Assert.assertTrue(isElementPresent(By.cssSelector(objectrepo.getProperty("addCustomerButton"))), "Login not successful");
        WebElement customerButtonIsDisplayed = driver.findElement(By.cssSelector(objectrepo.getProperty("addCustomerButton")));
        Assert.assertTrue(customerButtonIsDisplayed.isDisplayed(), "Login not successful");
    }
}
