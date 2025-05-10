package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateContactInfo extends ParentPage{
    public UpdateContactInfo() {PageFactory.initElements(GWD.getDriver(), this);}

    @FindBy(xpath = "//div[@class='login'][1]//input")
    public WebElement username;

    @FindBy(xpath = "//div[@class='login'][2]//input")
    public WebElement password;

    @FindBy(xpath = "//div[@class='login'][3]//input")
    public WebElement logınButton;

    @FindBy(xpath = "//a[text()='Update Contact Info']")
    public WebElement updateContactInfo;

    @FindBy(xpath = "//input[@id='customer.firstName']")
    public WebElement fırstName;

    @FindBy(xpath = "//input[@id='customer.lastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='customer.address.street']")
    public WebElement adress;

    @FindBy(xpath = "//input[@id='customer.address.city']")
    public WebElement cıty;

    @FindBy(xpath = "//input[@id='customer.address.state']")
    public WebElement state;

    @FindBy(xpath = "//input[@id='customer.address.zipCode']")
    public WebElement zıpCode;

    @FindBy(xpath = "//input[@id='customer.phoneNumber']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//input[@value='Update Profile']")
    public WebElement updateProfile;
}