package orange.com.PageObjects;

import orange.com.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage extends AbstractComponent {
    WebDriver driver;
    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "first-name")
    WebElement firstName;
    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement postalCode;
    @FindBy(xpath = "//input[@type='submit']")
    WebElement continueButton;

    public void checkOutForm(String firstNameText,String lastNameText, String postalCodeText) {
        firstName.sendKeys(firstNameText);
        lastName.sendKeys(lastNameText);
        postalCode.sendKeys(postalCodeText);
        continueButton.click();
    }
}
