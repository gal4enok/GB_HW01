import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.ProductPage;

public class AddToCartFromMainPageTest extends RegistrationBuyTwoDressesCheckCartTest {
    private ProductPage productPage;

    @Test
    public void actionsDemo(){

        WebElement product = driver.findElement(By.xpath("//*[@title='Faded Short Sleeve T-shirts']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(product).build().perform();


        productPage = new ProductPage(driver);
        productPage.clickAddToCart();

        product.click();
        //test
    }

    /*
    @Test(@DataProvider = "RegisterNewuser", dataProviderClass = data.RegistrationDataProvider)
    public void*/
}
