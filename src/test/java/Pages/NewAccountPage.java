package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class NewAccountPage extends ParentPage {

    public NewAccountPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Open New Account']")
    public WebElement openNewAccountLink;

    @FindBy(id = "type")
    public WebElement accountTypeDropdown;

    @FindBy(id = "fromAccountId")
    public WebElement fromAccountDropdown;

    @FindBy(css = "input.button[value='Open New Account']")
    public WebElement openNewAccountButton;

    @FindBy(css = "#rightPanel > div > div > p:nth-child(1)")
    public WebElement successMessage;

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickOpenNewAccountLink() {
        waitForElement(openNewAccountLink);
        openNewAccountLink.click();
    }

    public void selectAccountType(String accountType) {
        waitForElement(accountTypeDropdown);
        Select select = new Select(accountTypeDropdown);
        select.selectByVisibleText(accountType.toUpperCase());
    }

    public void selectFirstAvailableAccount() {
        waitForElement(fromAccountDropdown);
        Select select = new Select(fromAccountDropdown);
        String firstAccountId = select.getOptions().get(0).getText();
        select.selectByVisibleText(firstAccountId);
    }
    public void clickOpenAccountButton() {
        waitForElement(openNewAccountButton);
        openNewAccountButton.click();
    }

    public String getSuccessMessage() {
        waitForElement(successMessage);
        return successMessage.getText();
    }
}