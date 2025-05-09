package StepDefinitions;

import Pages.PayingBills;
import io.cucumber.java.en.*;
import net.datafaker.Faker;
import org.testng.Assert;

public class _03_PayingBills {
    PayingBills pb = new PayingBills();
    Faker dataFaker = new Faker();

    double initialBalance;
    double amountPaid;

    @And("user notes the current account balace")

    public void userNotesTheCurrentAccountBalace() {
        pb.myClick(pb.accountOverviewButton);
        String balanceText = pb.getTotalText().replace("$", "").replace(".", "");
        System.out.println(balanceText);
    }

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
        pb.myClick(pb.sendPayment);
    }

    @When("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        String header = pb.getBillPaymentCompleteText();
        Assert.assertEquals(header, "Bill Payment Complete");
        String amountHeader = pb.getAmountText();
        System.out.println(amountHeader);
        double amountPaid = Double.parseDouble(pb.getAmountText().replace("$", "").replace(".",""));

    }

    @Then("Click account overview button")
    public void clickAccountOverviewButton() {
        pb.myClick(pb.accountOverviewButton);
        String totalHeader = pb.getTotalText();
        System.out.println(totalHeader);
        double totalnumber = Double.parseDouble(pb.getAmountText().replace("$", "").replace("." ,""));
        System.out.println(totalnumber);

    }

    @When("User confirms that funds have been withdrawn from the account")
    public void userConfirmsThatFundsHaveBeenWithdrawnFromTheAccount() {
        pb.myClick(pb.accountOverviewButton);
        String currentBalaceText = pb.getTotalText().replace("$", "").replace(",","");
        double currentBalance = Double.parseDouble(currentBalaceText);
        System.out.println("Current balance: $" + currentBalance);

        double expectedBalance = initialBalance - amountPaid;
        Assert.assertEquals(currentBalance, expectedBalance, 0.01,
                "Funds have not been properly withdrawn from the account.");
    }

}

