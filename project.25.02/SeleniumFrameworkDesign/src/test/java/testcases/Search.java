package testcases;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

public class Search extends Base {

    public Search() {
        super();
    }
    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;
    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void verifySearchWithValidProduct() {
        homePage.enterProductIntoSearchBox(dataProp.getProperty("validProduct"));
        searchPage = homePage.clickOnSearchButton();

        Assert.assertTrue(searchPage.displayStatusOfValidProduct(), "Valid product HP is not displayed");
    }

    @Test(priority = 2)
    public void verifySearchWithInvalidProduct() {
        homePage.enterProductIntoSearchBox(dataProp.getProperty("invalidProduct"));
        searchPage = homePage.clickOnSearchButton();

//        String actualSearchMessage = searchPage.retrieveNoProductMessageText();
//        Assert.assertEquals(actualSearchMessage, dataProp.getProperty("noProductTextInSearchResults"), "No product message in search results is not displayed");
        Assert.assertEquals(searchPage.retrieveNoProductMessageText(), dataProp.getProperty("noProductTextInSearchResults"), "No product message in search results is not displayed");
    }

    @Test(priority = 3)
    public void verifySearchWithoutAnyProduct() {
        searchPage = homePage.clickOnSearchButton();

//        String actualSearchMessage = searchPage.retrieveNoProductMessageText();
//        Assert.assertEquals(actualSearchMessage, dataProp.getProperty("noProductTextInSearchResults"), "No product message in search results is not displayed");
        Assert.assertEquals(searchPage.retrieveNoProductMessageText(), dataProp.getProperty("noProductTextInSearchResults"), "No product message in search results is not displayed");
    }
}











