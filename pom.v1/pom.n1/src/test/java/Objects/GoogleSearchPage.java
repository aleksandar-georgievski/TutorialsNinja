package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {

    WebDriver driver;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    By searchBox = By.xpath("//textarea[@name='q']");
//    By searchButton = By.xpath("(//input[@name='btnK'])[1]");
    By facebookLink = By.xpath("//a//h3[contains(text(), 'Facebook - Најави се или регистрирај се')]");


    public void searchGoogle(String SearchInput) {
        try {
            driver.findElement(searchBox).sendKeys(SearchInput, Keys.ENTER);
//            driver.findElement(searchButton).sendKeys(Keys.ENTER);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Exceptions Caught: " + e.getMessage());
        }
    }

    public void clickFacebook() {
        try {
            driver.findElement(facebookLink).click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Exceptions Caught: " + e.getMessage());
        }
    }

}
