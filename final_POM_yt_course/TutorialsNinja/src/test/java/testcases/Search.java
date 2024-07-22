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

    SearchPage searchPage;

    public Search() {
        super();
    }

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = initializeBrowserAndOpenApplicationUrl(prop.getProperty("browserName"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void verifySearchWithValidProduct() {
        HomePage homePage = new HomePage(driver);
        homePage.enterProductIntoSearchBoxField(testProp.getProperty("validProduct"));
        searchPage = homePage.clickOnSearchButton();
//        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(testProp.getProperty("validProduct"));
//        driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
        Assert.assertTrue(searchPage.displayStatusOfHPProduct(), "Valid product HP is not displayed");
//        Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(), "Valid product HP is not displayed");
    }

    @Test(priority = 2)
    public void verifySearchWithInvalidProduct() {
        HomePage homePage = new HomePage(driver);
        homePage.enterProductIntoSearchBoxField(testProp.getProperty("invalidProduct"));
        searchPage = homePage.clickOnSearchButton();
//        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys((testProp.getProperty("invalidProduct")));
//        driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
        String actualSearchMessage = searchPage.retrieveNoProductMessageText();
//        String actualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
        Assert.assertEquals(actualSearchMessage, testProp.getProperty("noProductTextInSearchResult"), "No product message in search result is displayed");
    }

    @Test(priority = 3)
    public void verifySearchWithoutProvidingAnyProduct() {
        HomePage homePage = new HomePage(driver);
        searchPage = homePage.clickOnSearchButton();
//        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("");
//        driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
        String actualSearchMessage = searchPage.retrieveNoProductMessageText();
//        String actualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
        Assert.assertEquals(actualSearchMessage, testProp.getProperty("noProductTextInSearchResult"), "No product message in search result is displayed");
    }
}
















