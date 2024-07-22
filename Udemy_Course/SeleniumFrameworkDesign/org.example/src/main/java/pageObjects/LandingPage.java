package pageObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        // initialization of driver
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    WebElement userEmail = driver.findElement(By.id("userEmail"));
    //PageFactory
    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement submitButton;

    @FindBy(css = "div[aria-label='Incorrect email or password.']")
    WebElement errorMessage;

    public ProductCatalog loginApplication(String email, String password) {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        submitButton.click();
        ProductCatalog productCatalog = new ProductCatalog(driver);
        return productCatalog;
    }

    public String getErrorMessage() {
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }
    public void goToUrl(){
        driver.get("https://rahulshettyacademy.com/client");
    }

}




















