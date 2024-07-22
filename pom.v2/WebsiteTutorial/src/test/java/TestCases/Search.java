package TestCases;

import Base.Base;
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
//        driver = initializeBrowserAndOpenApplicationURL("firefox");
//        driver = initializeBrowserAndOpenApplicationURL("browserName");
        driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void verifySearchWithExistingProduct() {
        driver.findElement(By.xpath("//input[@type='text'][@placeholder='Search']")).sendKeys(dataprop.getProperty("validProduct"));
        driver.findElement(By.xpath("//div[@id='search']//descendant::button")).click();

        Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(), "Valid product HP is not displayed in the search result");
    }

    @Test(priority = 2)
    public void searchWithNonExistingProduct() {
        driver.findElement(By.xpath("//input[@type='text'][@placeholder='Search']")).sendKeys(dataprop.getProperty("invalidProduct"));
        driver.findElement(By.xpath("//div[@id='search']//descendant::button")).click();

        String  actualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
        Assert.assertEquals(actualSearchMessage, dataprop.getProperty("invalidProductMessage"), "No product message in search results is not displayed");
    }

    @Test(priority = 3)
    public void verifySearchWithoutAnyProduct() {
//        driver.findElement(By.xpath("//input[@type='text'][@placeholder='Search']")).sendKeys("");
        driver.findElement(By.xpath("//div[@id='search']//descendant::button")).click();

        String  actualSearchMessage = driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText();
        Assert.assertEquals(actualSearchMessage, dataprop.getProperty("invalidProductMessage", "No product message in search results is not displayed"));
    }
}


















