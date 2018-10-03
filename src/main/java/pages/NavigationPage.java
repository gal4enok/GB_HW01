package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage {

    public WebDriver driver;

    public NavigationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class = 'login']")
    private WebElement signIn;


    @FindBy(xpath = "//a[@class='account']/span")
    private WebElement userLoggedIn;

    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a")
    private WebElement dressesMenu;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    private WebElement viewMyShopingCart;

    public void openSignInPage(){
        signIn.click();
    }

    public String getTextUserIsLoggedIn(){
       return userLoggedIn.getText();
    }

    public void selectDressesMenu(){
        dressesMenu.click();
    }

    public void vieMyShoppingCart(){viewMyShopingCart.click();}

}
