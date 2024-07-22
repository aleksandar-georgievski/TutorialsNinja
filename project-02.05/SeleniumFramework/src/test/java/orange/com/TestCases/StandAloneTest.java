package orange.com.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {

    public static void main(String[] args) {
        String productName = "Sauce Labs Backpack";

        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        String landingPageTitle = driver.findElement(By.cssSelector(".product_label")).getText();
        Assert.assertEquals(landingPageTitle, "Products");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_item")));
        List <WebElement> inventoryItems = driver.findElements(By.cssSelector(".inventory_item"));
        WebElement productTitle = inventoryItems.stream().filter(product ->
                product.findElement(By.cssSelector(".inventory_item .inventory_item_label a")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
        assert productTitle != null;
        productTitle.findElement(By.cssSelector(".inventory_item_name")).click();
        String actualProduct = driver.findElement(By.cssSelector(".inventory_details_name")).getText();
        Assert.assertEquals(actualProduct, productName);
        driver.findElement(By.cssSelector(".btn_inventory")).click();
        driver.findElement(By.id("shopping_cart_container")).click();

        String actualCartItem = driver.findElement(By.cssSelector(".cart_list .inventory_item_name")).getText();
        Assert.assertEquals(actualCartItem, productName);
        driver.findElement(By.cssSelector(".checkout_button")).click();

        //Checkout Page
        driver.findElement(By.id("first-name")).sendKeys("Ace");
        driver.findElement(By.id("last-name")).sendKeys("Georg");
        driver.findElement(By.id("postal-code")).sendKeys("1111");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //Checkout Final Page
        String checkoutActualProduct = driver.findElement(By.xpath("//div[@class='cart_item']//div[@class='inventory_item_name']")).getText();
        Assert.assertEquals(checkoutActualProduct, productName);
        driver.findElement(By.linkText("FINISH")).click();

        //Checkout
        String actualOrderCompletedText = driver.findElement(By.className("complete-header")).getText();
        Assert.assertEquals(actualOrderCompletedText, "THANK YOU FOR YOUR ORDER");
        driver.close();
    }
}


//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".inventory_container")));
//        List <WebElement>  containers = driver.findElements(By.cssSelector(".inventory_container"));
//        WebElement productTitle = containers.stream().flatMap(product ->
//                product.findElements(By.xpath("//div[@class='inventory_item_label']//a//div")).stream()).filter(item -> item.getText().equals(productName)).findFirst().orElse(null);
//        assert productTitle != null;
//        productTitle.click();