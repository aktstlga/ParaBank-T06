package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayingBills extends ParentPage {
    public PayingBills() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Bill Pay']")
    public WebElement billPayButton;

    @FindBy(css = "input[name='payee.name']")
    public WebElement payeeName;

    @FindBy(css = "input[name='payee.address.street']")
    public WebElement adress;

    @FindBy(css = "input[name='payee.address.city']")
    public WebElement city;

    @FindBy(css = "input[name='payee.address.state']")
    public WebElement state;

    @FindBy(css = "input[name='payee.address.zipCode']")
    public WebElement zipCode;

    @FindBy(css = "input[name='payee.phoneNumber']")
    public WebElement phone;

    @FindBy(css = "input[name='payee.accountNumber']")
    public WebElement accountPlaceholder;

    @FindBy(css = "input[name='verifyAccount']")
    public WebElement verifyAccountPlaceholder;

    @FindBy(css = "input[name='amount']")
    public WebElement amount;

    @FindBy(css = "input[class='button']")
    public WebElement sendPayment;

    @FindBy(css = "#billpayResult > h1")
    public WebElement billPayHeader;

    @FindBy(id = "amount")
    public WebElement getAmount;

    @FindBy(css = "div[id='leftPanel'] > :nth-child(3) > :nth-child(2) > a")
    public WebElement accountOverviewButton;

    @FindBy(css = "table[id='accountTable'] > :nth-child(2) > :nth-child(2) > :nth-child(2) >b")
    public WebElement total;

    public String getBillPaymentCompleteText() {
        waitForElement(billPayHeader);
        return billPayHeader.getText();
    }

    public String getAmountText() {
        waitForElement(getAmount);
        return getAmount.getText();
    }

    public String getTotalText() {
        waitForElement(total);
        return total.getText();
    }
}

