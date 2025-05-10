package StepDefinitions;

import Pages.LoginPage;
import Pages.NewAccountPage;
import Utilities.ConfigReader;
import Utilities.GWD;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class _04_NewAccount {

    LoginPage loginPage = new LoginPage();
    NewAccountPage newAccountPage = new NewAccountPage();

    @When("the user opens a new {string} account")
    public void the_user_opens_a_new_account(String accountType) {
        newAccountPage.clickOpenNewAccountLink();
        newAccountPage.selectAccountType(accountType);
        newAccountPage.selectFirstAvailableAccount();
        newAccountPage.clickOpenAccountButton();
    }

    @Then("a confirmation message is displayed")
    public void a_confirmation_message_is_displayed() {
        String message = newAccountPage.getSuccessMessage();
        Assert.assertTrue(message.contains("Account Opened!"),
                "Success message not displayed or incorrect. Actual: " + message);
    }
}