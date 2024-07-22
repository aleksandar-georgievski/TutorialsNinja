package Pages;

import org.openqa.selenium.By;

import static Tests.SeleniumTest.driver;

public class HomePage {
    public static String hamburger_menu_xpath = "//input[@type='checkbox']";
    public static String onlineProducts_xpath = "//ul[@id='menu']//a[3]//li";
    public static void click_hamburger_menu() {
        driver.findElement(By.xpath(hamburger_menu_xpath)).click();
    }
    public static void click_orderProducts_link() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(onlineProducts_xpath)).click();
    }
}