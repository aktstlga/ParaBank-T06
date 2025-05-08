package StepDefinitions;

import Pages.LoginPage;
import Pages.NewAccountPage;
import Utilities.GWD;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class _04_NewAccount {

    LoginPage loginPage = new LoginPage();
    NewAccountPage newAccountPage = new NewAccountPage();

    @When("the user navigates to the Open New Account page")
    public void navigate_to_open_new_account() {
        newAccountPage.myClick(newAccountPage.openNewAccountLink);
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("openaccount"), "Open Account sayfasına ulaşılamadı.");
    }

    @And("the user selects account type {string}")
    public void user_selects_account_type(String accountType) {
        Select accountSelect = new Select(newAccountPage.accountTypeDropdown);
        accountSelect.selectByVisibleText(accountType);
    }

    @And("the user selects a valid existing account to transfer minimum balance")
    public void user_selects_existing_account() {
        Select fromAccount = new Select(newAccountPage.fromAccountDropdown);
        fromAccount.selectByIndex(0); // ilk geçerli hesabı seç
    }

    @And("the user clicks on Open New Account button")
    public void click_open_new_account() {
        newAccountPage.myClick(newAccountPage.openNewAccountButton);
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
        Assert.assertTrue(newAccountPage.newAccountId.isDisplayed(), "Yeni hesap numarası görünmüyor.");
    }
}
