package StepDefinitions;

import io.cucumber.java.en.*;
import Pages.MoneyTransfer;
import org.testng.Assert;

public class _05_MoneyTransfer {
    MoneyTransfer m = new MoneyTransfer();

    @When("Enter username and password and click login button")
    public void enter_username_and_password_and_click_login_button() {
        m.mySendKeys(m.username, "trt1");
        m.mySendKeys(m.password, "trt123");
        m.myClick(m.logınButton);
    }

    @And("Click on a new open account")
    public void clickOnANewOpenAccount() {
        m.myClick(m.openNewAccount);
        m.myClick(m.openNewAccountButton);
    }

    @Then("Then transfer the money")
    public void thenTransferTheMoney() {
        m.myClick(m.TransferFunds);
        m.mySendKeys(m.amount, "100");
        m.myClick(m.fromAccount);
        m.myClick(m.fromAccount2);
        Assert.assertTrue(m.message.getText().equals("Transfer Complete!"), "wrong message");
    }
}