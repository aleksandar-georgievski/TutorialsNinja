package orange.com.PageObjects;

import orange.com.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFinalPage extends AbstractComponent {
    WebDriver driver;
    public CheckoutFinalPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "complete-header")
    WebElement orderCompleteText;
    public String getCompletedOrderFinalMessage () {
     return orderCompleteText.getText();
    }
}
