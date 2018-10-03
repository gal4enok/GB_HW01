package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='Add to cart']")
    private WebElement addToCart;

    public void clickAddToCart(){
        Actions actions = new Actions(driver);
        actions.moveToElement(addToCart).build().perform();
        addToCart.click();
    }

}
