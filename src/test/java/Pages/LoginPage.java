// src/test/java/Pages/LoginPage.java

package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ParentPage {

    public LoginPage() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "#loginPanel > form > div:nth-child(2) > input")
    public WebElement usernameInput;

    @FindBy(css = "#loginPanel > form > div:nth-child(4) > input")
    public WebElement passwordInput;

    @FindBy(css = "#loginPanel > form > div:nth-child(5) > input")
    public WebElement loginButton;

    @FindBy(css = "#showOverview > h1")
    public WebElement accountOverviewHeader;

    @FindBy(css = "#leftPanel > ul > li:nth-child(8) > a")
    public WebElement logoutLink;

    @FindBy(css = "h1[class='title']")
    public WebElement error;

    // Hata mesajı <p> öğesinde olduğu için locator resetlendi
    @FindBy(css = "#rightPanel > p")
    public WebElement loginErrorMessage;

    public void enterUsername(String username) {
        mySendKeys(usernameInput, username);
    }

    public void enterPassword(String password) {
        mySendKeys(passwordInput, password);
    }

    public void clickLogin() {
        myClick(loginButton);
    }

    public String getOverviewHeaderText() {
        waitForElement(accountOverviewHeader);
        return accountOverviewHeader.getText();
    }

    public void clickLogout() {
        myClick(logoutLink);
    }

    public String getErrorMessageText() {
        waitForElement(error);
        return error.getText();

    }
}
