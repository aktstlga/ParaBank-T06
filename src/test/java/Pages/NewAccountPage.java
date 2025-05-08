package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAccountPage extends ParentPage {
    public NewAccountPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(linkText = "Open New Account")
    public WebElement openNewAccountLink;

    @FindBy(id = "type")
    public WebElement accountTypeDropdown;

    @FindBy(id = "fromAccountId")
    public WebElement fromAccountDropdown;

    @FindBy(css = "input[value='Open New Account']")
    public WebElement openNewAccountButton;

    @FindBy(id = "newAccountId")
    public WebElement newAccountId;

    @FindBy(xpath = "//h1[contains(text(),'Account Opened!')]")
    public WebElement successMessage;
}
