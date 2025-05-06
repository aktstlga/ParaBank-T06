package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register extends ParentPage{
    public Register() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(linkText = "Register")
    public WebElement registerButton;

    @FindBy(css = "input[id='customer.firstName']")
    public WebElement firstNamePlaceholder;

    @FindBy(css = "input[id='customer.lastName']")
    public WebElement lastNamePlaceholder;

    @FindBy(css = "input[id='customer.address.street']")
    public WebElement adressPlaceholder;

    @FindBy(css = "input[id='customer.address.city']")
    public WebElement cityPlaceholder;

    @FindBy(css = "input[id='customer.address.state']")
    public WebElement statePlaceholder;

    @FindBy(css = "input[id='customer.address.zipCode']")
    public WebElement zipCodePlaceholder;

    @FindBy(css = "input[id='customer.phoneNumber']")
    public WebElement phoneNumberPlaceholder;

    @FindBy(css = "input[id='customer.ssn']")
    public WebElement ssnPlaceholder;

    @FindBy(css="input[id='customer.username']")
    public  WebElement usernamePlaceholder;

    @FindBy(css="input[id='customer.password']")
    public  WebElement passwordPlaceholder;

    @FindBy(css="input[id='repeatedPassword']")
    public  WebElement repeatPlaceholder;

    @FindBy(css="input[type='submit'][value='Log In']")
    public  WebElement registerButtonOnForm;
}