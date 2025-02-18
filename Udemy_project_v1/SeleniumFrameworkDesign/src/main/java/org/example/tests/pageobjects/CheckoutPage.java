package org.example.tests.pageobjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponent {
    WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        super(driver);
        //initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".action__submit")
    WebElement submit;
    @FindBy(css = "[placeholder$='Select Country']")
    WebElement country;
//    @FindBy(xpath = "//button[contains(@class,'ta-item')])[2]")
    @FindBy(xpath = "//body//app-root//button[2]")
    WebElement selectCountryOption;
    By results = By.cssSelector(".ta-results");

    public void selectCountry(String countryName) {
        Actions a = new Actions(driver);
        a.sendKeys(country,countryName).build().perform();
        waitForElementToAppear(results);
        selectCountryOption.click();
    }

    public ConfirmationPage submitOrder() {
        submit.click();
        return new ConfirmationPage(driver);
    }
}
