package StepDefinitions;

import Pages.LoginPage;
import Utilities.ConfigReader;
import Utilities.GWD;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class _02_Login {

    LoginPage loginPage = new LoginPage();

    @Given("the user navigates to ParaBank homepage")
    public void navigateToHomePage() {
        GWD.getDriver().get(ConfigReader.getProperty("URL"));
    }

    @When("the user logs in with {string} and {string}")
    public void userLogsInWithCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("the Account Overview page is displayed")
    public void verifyAccountOverviewDisplayed() {
        String header = loginPage.getOverviewHeaderText();
        Assert.assertTrue(header.contains("Accounts Overview"),
                "Account Overview header not displayed. Actual: " + header);
    }

    @Then("an authentication error message is shown")
    public void verifyErrorMessageDisplayed() {
        String errorText = loginPage.getErrorMessageText();
        Assert.assertTrue(errorText.contains("The username and password could not be verified."),
                "Expected error message not displayed. Actual: " + errorText);
    }

    @And("the user logs out")
    public void userLogsOut() {
        loginPage.clickLogout();
    }
}
