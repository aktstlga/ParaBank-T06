package StepDefinitions;

import Pages.PayingBills;
import io.cucumber.java.en.*;
import net.datafaker.Faker;

public class _03_PayingBills {
    PayingBills pb = new PayingBills();
    Faker dataFaker = new Faker();

    @When("Cliks billpay button")
    public void clicksBill() {
        pb.myClick(pb.billPayButton);
    }

    @Then("User fills the invoice payment form")
    public void userFillsTheInvoicePaymentForm() {
        pb.mySendKeys(pb.payeeName, dataFaker.company().name());
        pb.mySendKeys(pb.adress, dataFaker.address().fullAddress());
        pb.mySendKeys(pb.city, dataFaker.address().city());
        pb.mySendKeys(pb.state, dataFaker.address().state());
        pb.mySendKeys(pb.zipCode, dataFaker.address().zipCode());
        pb.mySendKeys(pb.phone, dataFaker.phoneNumber().cellPhone());

        String accountNumber = String.valueOf(dataFaker.number().numberBetween(10000, 99999));
        pb.mySendKeys(pb.accountPlaceholder, accountNumber);
        pb.mySendKeys(pb.verifyAccountPlaceholder, accountNumber);

        String amountNumber = String.valueOf(dataFaker.number().numberBetween(1, 100));
        pb.mySendKeys(pb.amount, amountNumber);
    }

}
