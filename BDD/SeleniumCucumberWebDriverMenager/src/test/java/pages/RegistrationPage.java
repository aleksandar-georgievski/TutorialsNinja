package pages;

import org.openqa.selenium.By;
import utility.BrowserDriver;
import static org.junit.Assert.*;

public class RegistrationPage extends BrowserDriver {
    public static String userRegistrationTitle_xpath = "//*[contains(text(),'User Registration Page')]";

    public static void visibility_userRegistrationTitle() {
        String actualUserRegistrationTitle = driver.findElement(By.xpath(userRegistrationTitle_xpath)).getText();
        assertEquals("User Registration Page", actualUserRegistrationTitle);
    }
}
