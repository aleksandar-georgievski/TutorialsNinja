package stepDefinition;

import io.cucumber.java.en.Then;

import static pages.RegistrationPage.visibility_userRegistrationTitle;

public class RegistrationPage {
    @Then("User should be able to view the Registration page")
    public void user_should_be_able_to_view_the_Registration_page() {
        visibility_userRegistrationTitle();
    }
}
