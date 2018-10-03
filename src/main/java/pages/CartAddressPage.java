package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartAddressPage {

    public WebDriver driver;

    public CartAddressPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='address alternate_item box']/li[@class='address_firstname address_lastname']")
    private WebElement userFullName;

    @FindBy(xpath = "//ul[@class='address alternate_item box']/li[@class='address_address1 address_address2']")
    private WebElement userAddress;

    @FindBy(xpath = "//ul[@class='address alternate_item box']/li[@class='address_city address_state_name address_postcode']")
    private WebElement userCityStatePost;

    @FindBy(xpath = "//ul[@class='address alternate_item box']/li[@class='address_country_name']")
    private WebElement userCountry;

    @FindBy(xpath = "//ul[@class='address alternate_item box']/li[@class='address_phone_mobile']")
    private WebElement userMobile;

    @FindBy(xpath = "//button[@class='button btn btn-default button-medium']/span")
    private WebElement proceedToCheckout;

    public void clickProceedToCheckOut(){
        proceedToCheckout.click();
    }

    public String getUserFullName() {
        return userFullName.getText();
    }

    public String getUserAddress() {
        return userAddress.getText();
    }

    public String getUserCityStatePost() {
        return userCityStatePost.getText();
    }

    public String getUserCountry() {
        return userCountry.getText();
    }

    public String getMobile() {
        return userMobile.getText();
    }
}
