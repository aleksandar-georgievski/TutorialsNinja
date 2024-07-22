package pages;

import utility.BrowserDriver;
import org.openqa.selenium.By;
import static org.junit.Assert.*;

public class LoggedInPage extends BrowserDriver {
    public static String productCategory_formalShoes = "//div[@id='SmokeTests']//h3[@id='ShoeType']";
    public static String productCategory_sportsShoes = "//div[@id='RegressionTests']//h3[@id='ShoeType']";
    public static String productCategory_sneakersShoes = "//div[@id='VanguardTests']//h3[@id='ShoeType']";


    public static void visibility_productCategory_formalShoes() {
        String actualProductCategory_formal = driver.findElement(By.xpath(productCategory_formalShoes)).getText();
        assertEquals("Formal Shoes", actualProductCategory_formal);
    }
    public static void visibility_productCategory_sportsShoes() {
        String actualProductCategory_sports = driver.findElement(By.xpath(productCategory_sportsShoes)).getText();
        assertEquals("Sports", actualProductCategory_sports);
    }
    public static void visibility_productCategory_sneakersShoes() {
        String actualProductCategory_sneakers = driver.findElement(By.xpath(productCategory_sneakersShoes)).getText();
        assertEquals("Sneakers", actualProductCategory_sneakers);
    }
}
