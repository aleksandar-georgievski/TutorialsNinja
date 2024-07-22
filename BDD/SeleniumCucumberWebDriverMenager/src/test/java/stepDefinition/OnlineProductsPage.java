package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static pages.OnlineProductsPage.click_formalShoes_dropdown;
import static pages.OnlineProductsPage.getText_formalShoes_firstProduct;

public class OnlineProductsPage {
    @When("User clicks on Formal Shoes drop down")
    public void user_clicks_on_Formal_Shoes_drop_down() throws InterruptedException {
        click_formalShoes_dropdown();
    }

    @Then("User should be able to view the Products")
    public void user_should_be_able_to_view_the_products() throws InterruptedException {
        getText_formalShoes_firstProduct();
    }

}
