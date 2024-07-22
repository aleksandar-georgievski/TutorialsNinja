package testcases;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Search extends Base {

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
        driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validProduct"));
        driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();

        Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(), "Valid Product HP is not displayed in search");
    }

    @Test(priority = 2)
    public void verifySearchWithInvalidProduct() {
        driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("invalidProduct"));
        driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();

        String actualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
        Assert.assertEquals(actualSearchMessage, dataProp.getProperty("noProductTextInSearchResults"), "No product in search results is displayed");
    }

    @Test(priority = 3)
    public void verifySearchWithoutAnyProduct() {
        driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();

        String actualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
        Assert.assertEquals(actualSearchMessage, dataProp.getProperty("noProductTextInSearchResults"), "No product in search results is displayed");
    }
}
























