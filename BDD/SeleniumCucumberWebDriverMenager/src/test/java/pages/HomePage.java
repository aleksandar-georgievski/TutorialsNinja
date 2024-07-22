package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.BrowserDriver;

public class HomePage extends BrowserDriver {
    public static String hamburger_menu_xpath = "//div[@id='menuToggle']/input";
    public static String signIn_link_xpath = "//ul[@id='menu']/a[2]/li";
    public static String onlineProducts_link_xpath = "//ul[@id='menu']/a[3]/li";

    public static void click_hamburger_menu() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        Thread.sleep(2000);
        driver.findElement(By.xpath(hamburger_menu_xpath)).click();
    }

    public static void click_signIn_link() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(signIn_link_xpath)).click();
    }
    public static void click_onlineProducts_link() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(onlineProducts_link_xpath)).click();
    }
}
