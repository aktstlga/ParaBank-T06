package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewAccountPage extends ParentPage {

    public NewAccountPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement loginButton;

    @FindBy(linkText = "Open New Account")
    public WebElement openNewAccountLink;

    @FindBy(id = "type")
    public WebElement accountTypeDropdown;

    @FindBy(id = "fromAccountId")
    public WebElement fromAccountDropdown;

    @FindBy(xpath = "//input[@value='Open New Account']")
    public WebElement openNewAccountButton;

    @FindBy(id = "newAccountId")
    public WebElement newAccountNumber;

    @FindBy(xpath = "//h1[contains(text(),'Account Opened!')]")
    public WebElement successMessage;

    public void goToHomePage() {
        GWD.getDriver().get("https://parabank.parasoft.com/");
    }

    public void login(String user, String pass) {
        mySendKeys(username, user);
        mySendKeys(password, pass);
        myClick(loginButton);
    }

    public boolean isLoggedIn() {
        return openNewAccountLink.isDisplayed();
    }

    public void goToNewAccountPage() {
        myClick(openNewAccountLink);
    }

    public void selectAccountType(String type) {
        Select select = new Select(accountTypeDropdown);
        select.selectByVisibleText(type);
    }

    public void selectExistingAccount() {
        Select select = new Select(fromAccountDropdown);
        select.selectByIndex(0); // ilk aktif hesabı seçer
    }

    public void clickOpenAccount() {
        myClick(openNewAccountButton);
    }

    public boolean isAccountCreatedSuccessfully(String accountType) {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText().toLowerCase().contains("account opened");
    }

    public String getNewAccountNumber() {
        wait.until(ExpectedConditions.visibilityOf(newAccountNumber));
        return newAccountNumber.getText();
    }
}
