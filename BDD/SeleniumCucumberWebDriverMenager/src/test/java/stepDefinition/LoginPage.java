package stepDefinition;

import io.cucumber.java.en.When;
import static pages.LoginPage.*;

public class LoginPage {
    @When("User successfully enters the log in details")
    public void user_successfully_enters_the_log_in_details() throws InterruptedException {
        sendKeys_username();
        sendKeys_password();
        click_login_button();
    }

    @When("User clicks on new Registration button")
    public void user_clicks_on_new_Registration_button() throws InterruptedException {
        click_newRegister_button();
    }
}
