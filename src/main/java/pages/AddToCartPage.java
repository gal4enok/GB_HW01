package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage {

    public WebDriver driver;

    public AddToCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@title='Continue shopping']")
    private WebElement continueShopping;

    @FindBy(xpath = "//span[@title='Close window']")
    private WebElement closeCart;


    public void clickContinueShopping(){
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOf(closeCart));

        continueShopping.click();

        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@title='Continue shopping']")));

    }
}
