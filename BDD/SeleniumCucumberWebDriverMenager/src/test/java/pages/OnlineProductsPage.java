package pages;

import org.openqa.selenium.By;
import utility.BrowserDriver;
import static org.junit.Assert.*;

public class OnlineProductsPage extends BrowserDriver {
    public static String formalShoes_dropdown_class = "formalshoedropdown";
    public static String formalShoes_webTable_xpath = "/html/body/div[2]/table";
    public static String formalShoes_webTable_tr_xpath = "/html/body/div[2]/table/tbody/tr[1]/td[1]";
    public static void click_formalShoes_dropdown() throws InterruptedException {
        driver.findElement(By.className(formalShoes_dropdown_class)).click();
    }
    public static void getText_formalShoes_firstProduct() {
        String actual_firstProduct = driver.findElement(By.xpath(formalShoes_webTable_tr_xpath)).getText();
        assertEquals("   Classic Cheltenham", actual_firstProduct);
    }
}
