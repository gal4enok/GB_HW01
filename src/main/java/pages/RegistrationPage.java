package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    public WebDriver driver;

    //page factory
    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "id_gender2")
    private WebElement mrsGender;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstName;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(xpath = "//*[@id='days']")
    private WebElement dayDropDown;

    @FindBy(xpath = "//*[@id='months']")
    private WebElement monthDropDown;

    @FindBy(xpath = "//*[@id='years']")
    private WebElement yearDropDown;

    @FindBy(id = "newsletter")
    private WebElement newsletter;

    @FindBy(id = "optin")
    private WebElement optin;

    @FindBy(id = "firstname")
    private WebElement firstName;

    @FindBy(id = "lastname")
    private WebElement lastName;

    @FindBy(id = "company")
    private WebElement company;

    @FindBy(id = "address1")
    private WebElement address1;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(xpath = "//*[@id='id_state']")
    private WebElement stateDropDown;

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(id = "phone_mobile")
    private WebElement phoneMobile;

    @FindBy(id = "alias")
    private WebElement alias;

    @FindBy(id = "submitAccount")
    private WebElement submitAccountButton;



    public void fillRegistrationForm(String userEmail, String userName, String userSurname, String userCompany,
                                      String userPass, String userBDDay, int userBDMonth, String userBDYear,
                                      String userAddr, String userCity, int userState, String userPost,
                                      String userMobile) {
        mrsGender.click();

        customerFirstName.clear();
        customerFirstName.sendKeys(userName);

        customerLastName.clear();
        customerLastName.sendKeys(userSurname);

        email.clear();
        email.sendKeys(userEmail);

        password.clear();
        password.sendKeys(userPass);

        Select valueDay = new Select(dayDropDown);
        valueDay.selectByValue(userBDDay);

        Select valueMonth = new Select(monthDropDown);
        valueMonth.selectByIndex(userBDMonth);

        Select valueYear = new Select(yearDropDown);
        valueYear.selectByValue(userBDYear);

        newsletter.click();
        optin.click();

        firstName.clear();
        firstName.sendKeys(userName);

        lastName.clear();
        lastName.sendKeys(userSurname);

        company.clear();
        company.sendKeys(userCompany);

        address1.clear();
        address1.sendKeys(userAddr);

        city.clear();
        city.sendKeys(userCity);

        Select valueState = new Select(stateDropDown);
        valueState.selectByIndex(userState);

        postcode.clear();
        postcode.sendKeys(userPost);

        phoneMobile.clear();
        phoneMobile.sendKeys(userMobile);

        alias.clear();
        alias.sendKeys(userAddr);
    }

    public void clickRegister() {
        submitAccountButton.click();
    }

    }
