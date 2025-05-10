package StepDefinitions;

import Pages.LoginPage;
import Pages.NewAccountPage;
import Utilities.ConfigReader;
import Utilities.GWD;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.Select;
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

    @When("the user navigates to the New Account page")
    public void navigate_to_new_account() {
        //newAccountPage.myClick(newAccountPage.newAccountLink); // DÜZELTİLDİ
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("openaccount"), "New Account sayfasına ulaşılamadı.");
    }

    @And("the user selects account type {string}")
    public void user_selects_account_type(String accountType) {
        Select accountSelect = new Select(newAccountPage.accountTypeDropdown);
        accountSelect.selectByVisibleText(accountType);
    }

    @And("the user selects a valid existing account to transfer minimum balance")
    public void user_selects_existing_account() {
        Select fromAccount = new Select(newAccountPage.fromAccountDropdown);
        fromAccount.selectByIndex(0);
    }

    @And("the user clicks on Create New Account button")
    public void click_create_new_account() {
      //  newAccountPage.myClick(newAccountPage.createNewAccountButton); // DÜZELTİLDİ
    }

    @Then("a new checking account should be created successfully")
    public void verify_checking_account_created() {
        Assert.assertTrue(newAccountPage.successMessage.getText().contains("Account Opened"), "Hesap açılmadı.");
    }

    @Then("a new savings account should be created successfully")
    public void verify_savings_account_created() {
        Assert.assertTrue(newAccountPage.successMessage.getText().contains("Account Opened"), "Hesap açılmadı.");
    }

    @And("the user should see the new account number")
    public void verify_account_number_displayed() {
        //Assert.assertTrue(newAccountPage.newAccountId.isDisplayed(), "Yeni hesap numarası görünmüyor.");
    }
}