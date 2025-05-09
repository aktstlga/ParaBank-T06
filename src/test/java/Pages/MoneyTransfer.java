package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoneyTransfer extends ParentPage {
    public MoneyTransfer() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='login'][1]//input")
    public WebElement username;

    @FindBy(xpath = "//div[@class='login'][2]//input")
    public WebElement password;

    @FindBy(xpath = "//div[@class='login'][3]//input")
    public WebElement logınButton;

    @FindBy(xpath = "(//*[text()='Open New Account'])[1]")
    public WebElement openNewAccount;

    @FindBy(xpath = "//input[@value='Open New Account']")
    public WebElement openNewAccountButton;

    @FindBy(xpath = "//*[text()='Transfer Funds']")
    public WebElement TransferFunds;

    @FindBy(xpath = "//input[@id='amount']")
    public WebElement amount;

    @FindBy(xpath = "//input[@value='Transfer']")
    public WebElement transferbutton;

    @FindBy(xpath = "//*[text()='Transfer Complete!']")
    public WebElement message;

}
