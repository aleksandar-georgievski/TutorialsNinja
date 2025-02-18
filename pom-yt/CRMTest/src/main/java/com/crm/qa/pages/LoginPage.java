package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import jdk.jfr.Name;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Page Factory - OR
    @FindBy(name="username")
    WebElement username;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    WebElement signUpBtn;

    @FindBy(xpath = "//img[@class='img-responsive'][@alt='Free CRM Software for customer relationship management, sales and support']")
    WebElement crmLogo;

    // Initializing the Page Objects
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    // Actions
    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateCRMImage() {
        return crmLogo.isDisplayed();
    }

}
