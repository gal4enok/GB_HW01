package pages;

import model.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutentificationPage {

    public WebDriver driver;

    public AutentificationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_create")
    private WebElement emailCreateAnAccount;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountButton;


    @FindBy(id = "email")
    private WebElement emailAlreadyRegistered;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@title='Recover your forgotten password']")
    private WebElement forgotPassword;


    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
    private WebElement validationMessage;

    //laizy inititalization
    public AutentificationPage typeEmail(Account account){
        emailAlreadyRegistered.sendKeys(account.getEmail());
        return this;
    }

    public AutentificationPage typePassword(Account account){
        password.sendKeys(account.getPassword());
        return this;
    }

    public void loginIntoAccount(String userEmail, String userPass){
        emailAlreadyRegistered.sendKeys(userEmail);
        password.sendKeys(userPass);
        loginButton.click();
    }

    public void createAnAccount(String userEmail){
        emailCreateAnAccount.sendKeys(userEmail);
        createAnAccountButton.click();
    }


    public void clickSignIn(){
        loginButton.click();
    }

    public void clickForgotPassword(){
        forgotPassword.click();
    }

    public String getValidationMessage() {
        return validationMessage.getText();
    }
}
