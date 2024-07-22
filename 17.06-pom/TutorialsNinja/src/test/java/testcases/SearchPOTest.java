package testcases;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchPage;

public class SearchPOTest extends Base {

    public SearchPOTest() {
        super();
    }
    public WebDriver driver;
    SearchPage searchPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void verifySearchWithValidProduct() {
        homePage.searchForAProduct(dataProp.getProperty("validProduct"));

        Assert.assertTrue(searchPage.displayStatusOfValidHPProduct(), "Valid Product HP is not displayed in search");
    }

    @Test(priority = 2)
    public void verifySearchWithInvalidProduct() {
        homePage.searchForAProduct(dataProp.getProperty("invalidProduct"));

//        Assert.assertEquals(searchPage.retrieveNoProductMessageText(), dataProp.getProperty("noProductTextInSearchResults"), "No product in search results is displayed");
        Assert.assertEquals(searchPage.retrieveNoProductMessageText(),"sdadada", "No product in search results is displayed");

    }

    @Test(priority = 3, dependsOnMethods = "verifySearchWithInvalidProduct")
    public void verifySearchWithoutAnyProduct() {
        searchPage = homePage.clickOnSearchButton();

        Assert.assertEquals(searchPage.retrieveNoProductMessageText(), dataProp.getProperty("noProductTextInSearchResults"), "No product in search results is displayed");
    }
}
























