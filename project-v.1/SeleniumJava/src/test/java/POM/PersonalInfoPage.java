package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalInfoPage {
    private WebDriver driver;

    private WebElement getFirstNameField() {
        return driver.findElement(By.id("FAKE LOCATOR"));
    }
    private WebElement getLastNameField() {
        return driver.findElement(By.id("FAKE LOCATOR"));
    }
    private WebElement getZipCodeField() {
        return driver.findElement(By.id("FAKE LOCATOR"));
    }

    public void fillOutPersonalInformation() {
        getFirstNameField().sendKeys("firstName");
        getLastNameField().sendKeys("lastName");
        getZipCodeField().sendKeys("123 City");
    }
}
