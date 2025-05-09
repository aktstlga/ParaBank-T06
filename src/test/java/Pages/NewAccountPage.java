package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAccountPage extends ParentPage {
    public WebElement createNewAccountButton;

    public NewAccountPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(linkText = "New Account")
    public WebElement newAccountLink;

    @FindBy(id = "type")
    public WebElement accountTypeDropdown;

    @FindBy(id = "fromAccountId")
    public WebElement fromAccountDropdown;

    @FindBy(css = "input.button[value='Open New Account']")
    public WebElement openNewAccountButton;

    @FindBy(id = "newAccountId")
    public WebElement newAccountId;

    @FindBy(xpath = "//h1[contains(text(),'Account Opened!')]")
    public WebElement successMessage;
}