package StepDefinitions;

import Pages.UpdateContactInfo;
import Utilities.GWD;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class _06_UpdateContactInfo {
    UpdateContactInfo updateContactInfo = new UpdateContactInfo();

    @Given("User is on the ParaBank Login Page")
    public void userIsOnTheParaBankLoginPage() {
        GWD.getDriver().get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("User login with valid credentials")
    public void userLoginWithValidCredentials() {
        updateContactInfo.mySendKeys(updateContactInfo.username, "test");
        updateContactInfo.mySendKeys(updateContactInfo.password, "test123");
        updateContactInfo.myClick(updateContactInfo.logınButton);
    }

    @And("Navigate to the update contact info page")
    public void navigateToTheUpdateContactInfoPage() {
        updateContactInfo.myClick(updateContactInfo.updateContactInfo);
    }

    @And("Update profile field with new valid data")
    public void updateProfileFieldWithNewValidData() {
        updateContactInfo.mySendKeys(updateContactInfo.fırstName, "Ronnie");
        updateContactInfo.mySendKeys(updateContactInfo.lastName, "Potter");
        updateContactInfo.mySendKeys(updateContactInfo.adress, "9489 Kohler Parkway,Jewlland FL");
        updateContactInfo.mySendKeys(updateContactInfo.cıty, "Miami");
        updateContactInfo.mySendKeys(updateContactInfo.state, "Sunshine State");
        updateContactInfo.mySendKeys(updateContactInfo.zıpCode, "33101");
        updateContactInfo.mySendKeys(updateContactInfo.phoneNumber, "9990999");
    }

    @And("Click the update profile button")
    public void clickTheUpdateProfileButton() {
        updateContactInfo.myClick(updateContactInfo.updateProfıle);
    }

    @Then("Profile Updated message should be visible appear")
    public void profileUpdatedMessageShouldBeVisibleAppear() {{
        String pageSource = GWD.getDriver().getPageSource();
        Assert.assertTrue(pageSource.contains(" Profile Updated "), "Sayfada hiçbir ' Profile Updated' hatası bulunamadı!");

        }
    }

    @And("And Leave profile fields empty or enter invalid data")
    public void andLeaveProfileFieldsEmptyOrEnterInvalidData() {
        updateContactInfo.mySendKeys(updateContactInfo.fırstName, "Ronnie");
        updateContactInfo.mySendKeys(updateContactInfo.lastName, "");
        updateContactInfo.mySendKeys(updateContactInfo.adress, "9489 Kohler Parkway,Jewlland FL");
        updateContactInfo.mySendKeys(updateContactInfo.cıty, "Miami");
        updateContactInfo.mySendKeys(updateContactInfo.state, "");
        updateContactInfo.mySendKeys(updateContactInfo.zıpCode, "");
        updateContactInfo.mySendKeys(updateContactInfo.phoneNumber, "9990999");
    }

    @Then("is required message\\(s) should appear")
    public void isRequiredMessageSShouldAppear() {
        String pageSource = GWD.getDriver().getPageSource();
        Assert.assertTrue(pageSource.contains(" is required"), "Sayfada hiçbir ' is required' hatası bulunamadı!");
    }
}


