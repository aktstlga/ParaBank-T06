// src/test/java/StepDefinitions/_02_Login.java

package StepDefinitions;

import Pages.LoginPage;
import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class _02_Login {
    LoginPage loginPage = new LoginPage();

    @Given("the user navigates to ParaBank homepage")
    public void navigateToHomePage() {
        GWD.getDriver().get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("the user logs in with {string} and {string}")
    public void userLogsInWithCredentials(String user, String pass) {
        loginPage.enterUsername(user);
        loginPage.enterPassword(pass);
        loginPage.clickLogin();
    }

    @Then("the Account Overview page is displayed")
    public void verifyAccountOverviewDisplayed() {
        String header = loginPage.getOverviewHeaderText();
        Assert.assertEquals(header, "Accounts Overview");
    }

    @And("the user logs out")
    public void userLogsOut() {
        loginPage.clickLogout();
    }

    @Then("an authentication error message is shown")
    public void verifyErrorMessageDisplayed() {
        String err = loginPage.getErrorMessageText();
        Assert.assertTrue(err.contains("could not be verified"),
                "Expected error message not found, actual: " + err);
    }

    @After
    public void tearDown() {
        GWD.quitDriver();
    }
}
