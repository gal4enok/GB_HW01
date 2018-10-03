package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage {
    public WebDriver driver;

    public CreateAnAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_create")
    private WebElement emailAddress;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountButton;


    public void inputEmail(String fieldValue) {
        emailAddress.clear();
        emailAddress.sendKeys(fieldValue);
    }

    public void clickCreateAnAccountButton() {
        createAnAccountButton.click();
    }

}
