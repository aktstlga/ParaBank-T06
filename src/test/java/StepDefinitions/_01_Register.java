package StepDefinitions;

import Pages.ParentPage;
import Pages.Register;
import Utilities.ConfigReader;
import Utilities.GWD;
import io.cucumber.java.en.*;
import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.UUID;

public class _01_Register {
    Register register = new Register();
    Faker dataFaker = new Faker();

    @Given("Navigate to ParaBank Site")
    public void navigate_to_para_bank_site() {
        GWD.getDriver().get(ConfigReader.getProperty("URL"));
    }

    @Given("Navigate to Register Site")
    public void navigate_to_register_site() {
        register.myClick(register.registerButton);
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("register"), "Siteye geçiş yapılamadı.");
    }

    @When("Enter Signing Up Informations and click on Register button")
    public void enter_signing_up_ınformations_and_click_on_register_button() {
        boolean status = false;
        do {
            register.mySendKeys(register.firstNamePlaceholder, dataFaker.name().firstName());
            register.mySendKeys(register.lastNamePlaceholder, dataFaker.name().lastName());
            register.mySendKeys(register.adressPlaceholder, dataFaker.address().fullAddress());
            register.mySendKeys(register.cityPlaceholder, dataFaker.address().city());
            register.mySendKeys(register.statePlaceholder, dataFaker.address().state());
            register.mySendKeys(register.zipCodePlaceholder, dataFaker.address().zipCode());
            register.mySendKeys(register.phoneNumberPlaceholder, dataFaker.phoneNumber().cellPhone());
            register.mySendKeys(register.ssnPlaceholder, dataFaker.idNumber().ssnValid());

            ConfigReader.updateProperty("username");
            register.mySendKeys(register.usernamePlaceholder, ConfigReader.getProperty("username"));
            ConfigReader.updateProperty("password");
            register.mySendKeys(register.passwordPlaceholder, ConfigReader.getProperty("password"));
            register.mySendKeys(register.repeatPlaceholder, ConfigReader.getProperty("password"));
            register.myClick(register.registerButtonOnForm);

            List<WebElement> errorForUsername = GWD.getDriver().findElements(By.id("customer.username.errors"));
            if (!errorForUsername.isEmpty() && errorForUsername.get(0).isDisplayed()) {
                status = true;
            } else {
                status = false;
            }
        } while (status == true);
    }

    @Then("User should register and login successfully")
    public void user_should_register_and_login_successfully() {
        register.waitForElement(register.messeageOfNot);
        Assert.assertTrue(register.messeageOfNot.getText().contains(ConfigReader.getProperty("username")), "Notification mesajı çıkamadı.");
        GWD.quitDriver();
    }
}