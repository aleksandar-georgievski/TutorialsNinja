package orange.com.PageObjects;

import orange.com.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepTwoPage extends AbstractComponent {
    WebDriver driver;
    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='cart_item']//div[@class='inventory_item_name']")
    WebElement checkoutProductText;
    @FindBy(linkText = "FINISH")
    WebElement finishButton;

    public String getCheckoutProductItemText() {
        return checkoutProductText.getText();
    }
    public void clickOnFinishButton(){
        finishButton.click();
    }
}
