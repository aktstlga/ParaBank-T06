package StepDefinitions;

import Pages.PayingBills;
import io.cucumber.java.en.*;
import net.datafaker.Faker;
import org.testng.Assert;

public class _03_PayingBills {
    PayingBills pb = new PayingBills();
    Faker dataFaker = new Faker();

    double balance;
    double amountPaid;
    double totalnumber;

    @And("user notes the current account balace")
    public void userNotesTheCurrentAccountBalace() {
        pb.myClick(pb.accountOverviewButton);
        String balanceText = pb.getTotalText().replace("$", "");
        balance = Double.parseDouble(balanceText);
        System.out.println("Initial balance = " + balance);
    }

    @When("Clicks billpay button")
    public void clicksBill() {
        pb.myClick(pb.billPayButton);
    }

    @Then("The User fills the invoice payment form")
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

    }

    @And("Verifies against user invoice")
    public void verifiesAgainstUserInvoice() {
        String amountText = pb.getAmountText().replace("$", "");
        amountPaid = Double.parseDouble(amountText);
        System.out.println("Amount paid = " + amountPaid);
    }

    @Then("Clicks account overview button")
    public void clickAccountOverviewButton() {
        pb.myClick(pb.accountOverviewButton);
    }

    @And("The User looks at last account activity")
    public void userLooksAtLastAccountActivity() {
        String newBalanceText = pb.getTotalText().replace("$", "");
        totalnumber = Double.parseDouble(newBalanceText);
        System.out.println("New balance = " + totalnumber);
        ;
    }

    @When("The User confirms that funds have been withdrawn from the account")
    public void userConfirmsThatFundsHaveBeenWithdrawnFromTheAccount() {
        double calculated = totalnumber + amountPaid;
        System.out.println("Calculated previous balance: " + calculated);
        System.out.println("Recorded previous balance: " + balance);

        Assert.assertEquals(calculated, balance, "Balance, payment amount, and new total do not match!");
    }
}

