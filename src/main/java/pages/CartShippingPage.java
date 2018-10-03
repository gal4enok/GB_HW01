package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartShippingPage {

        public WebDriver driver;

        public CartShippingPage(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

    @FindBy(xpath = "//button[@class='button btn btn-default standard-checkout button-medium']/span")
    private WebElement proceedToCheckout;

    @FindBy(id = "cgv")
    private WebElement checkboxIAgree;


    public void clickProceedToCheckOut(){
        proceedToCheckout.click();
    }

    public void clickIAgreeOnShipping(){
        checkboxIAgree.click();
    }
}
