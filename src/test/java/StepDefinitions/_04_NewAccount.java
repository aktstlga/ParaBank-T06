package StepDefinitions;

import Pages.NewAccountPage;
import Utilities.GWD;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class _04_NewAccount {

    NewAccountPage newAccountPage = new NewAccountPage();

    @When("the user opens a new {string} account")
    public void the_user_opens_a_new_account(String accountType) {
        newAccountPage.clickOpenNewAccountLink();
        newAccountPage.selectAccountType(accountType);
        newAccountPage.selectFirstAvailableAccount();
        newAccountPage.clickOpenNewAccountButton();
    }

    @Then("a confirmation message is displayed")
    public void a_confirmation_message_is_displayed() {
        String message = newAccountPage.getSuccessMessage();
        Assert.assertTrue(message.contains("Account Opened!"),
                "Success message not displayed or incorrect. Actual: " + message);
    }

    @When("the user navigates to the New Account page")
    public void navigate_to_new_account() {
        newAccountPage.clickOpenNewAccountLink();
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("openaccount"), "New Account sayfasına ulaşılamadı.");
    }

    @And("the user selects account type {string}")
    public void user_selects_account_type(String accountType) {
        Select accountSelect = new Select(newAccountPage.accountTypeDropdown);
        accountSelect.selectByVisibleText(accountType);
    }

    @And("the user selects a valid existing account to transfer minimum balance")
    public void user_selects_existing_account() {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(newAccountPage.accountTypeDropdown));
        Select select = new Select(newAccountPage.accountTypeDropdown);
        select.selectByIndex(0);
    }

    @And("the user clicks on Open New Account button")
    public void the_user_clicks_on_open_new_account_button() {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
        By locator = By.xpath("//input[@value='Open New Account']");

        for (int i = 0; i < 2; i++) {
            try {
                WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
                wait.until(ExpectedConditions.elementToBeClickable(element));
                new Actions(GWD.getDriver()).doubleClick(element).perform();
                break;
            } catch (StaleElementReferenceException e) {
                System.out.println("Stale element yakalandı, tekrar deneniyor...");
            }
        }
    }

    @Then("a new checking account should be created successfully")
    public void verify_checking_account_created() {
        Assert.assertTrue(newAccountPage.getSuccessMessage().contains("Account Opened"), "Hesap açılmadı.");
    }

    @Then("a new savings account should be created successfully")
    public void verify_savings_account_created() {
        Assert.assertTrue(newAccountPage.getSuccessMessage().contains("Account Opened!"), "Hesap açılmadı.");
    }

    @And("the user should see the new account number")
    public void verify_account_number_displayed() {
        newAccountPage.waitForElement(newAccountPage.newAccountId);
        String accountNumber = newAccountPage.getNewAccountNumber();
        Assert.assertNotNull(accountNumber, "Hesap numarası boş.");
        System.out.println("Yeni hesap numarası: " + accountNumber);
    }
}