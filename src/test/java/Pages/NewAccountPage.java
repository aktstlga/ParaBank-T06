package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewAccountPage extends ParentPage {

    public NewAccountPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Open New Account']")
    public WebElement openNewAccount;

    @FindBy(id = "type")
    public WebElement accountTypeDropdown;

    @FindBy(id = "fromAccountId")
    public WebElement fromAccountDropdown;

    @FindBy(xpath = "//input[@value='Open New Account']")
    public WebElement openNewAccountButton;

    @FindBy(xpath = "//h1[contains(text(),'Account Opened!')]")
    public WebElement successMessage;

    @FindBy(id = "newAccountId")
    public WebElement newAccountId;

    public void clickOpenNewAccountLink() {
        openNewAccount.click();
    }

    public void selectAccountType(String accountType) {
        waitForElement(accountTypeDropdown);
        Select select = new Select(accountTypeDropdown);
        select.selectByVisibleText(accountType.toUpperCase());
    }

    public void selectFirstAvailableAccount() {
        wait.until(driver -> new Select(fromAccountDropdown).getOptions().size() > 0);
        Select select = new Select(fromAccountDropdown);
        select.selectByIndex(0);
    }

    public void clickOpenNewAccountButton() {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(openNewAccountButton)).click();
    }

    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText();
    }

    public String getNewAccountNumber() {
        waitForElement(newAccountId);
        return newAccountId.getText();
    }
}