package StepDefinitions;

import Pages.ParentPage;
import Pages.Register;
import Utilities.GWD;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class _01_Register {
    Register register = new Register();

    @Given("Navigate to ParaBank Site")
    public void navigate_to_para_bank_site() {
        GWD.getDriver().get("https://parabank.parasoft.com/parabank/index.htm");
    }
    @Given("Navigate to Register Site")
    public void navigate_to_register_site() {
        register.myClick(register.registerButton);
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("register"),"Siteye geçiş yapılamadı.");
    }
    @When("Enter Signing Up Informations and click on Register button")
    public void enter_signing_up_ınformations_and_click_on_register_button() {

    }
    @Then("User should register and login successfully")
    public void user_should_register_and_login_successfully() {

    }
}