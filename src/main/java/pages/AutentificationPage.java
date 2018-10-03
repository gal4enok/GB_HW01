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

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@title='Recover your forgotten password']")
    private WebElement forgotPassword;

    //laizy inititalization
    public AutentificationPage typeEmail(Account account){
        email.sendKeys(account.getEmail());
        return this;
    }

    public AutentificationPage typePassword(Account account){
        password.sendKeys(account.getPassword());
        return this;
    }

    public void clickSignIn(){
        loginButton.click();
    }

    public void clickForgotPassword(){
        forgotPassword.click();
    }

}
