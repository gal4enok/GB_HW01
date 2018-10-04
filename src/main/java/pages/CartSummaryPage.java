package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class CartSummaryPage {
    public WebDriver driver;

    public CartSummaryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "summary_products_quantity")
    private WebElement productsQuantity;

    @FindBy(xpath = "//tr[1]/td[6]")
    private WebElement priceFirstProduct;

    @FindBy(xpath = "//tr[2]/td[6]")
    private WebElement priceSecondProduct;

    @FindBy(xpath = "//span[@class='price special-price']")
    private WebElement specialPrice;

    @FindBy(xpath = "//span[@class='old-price']")
    private WebElement oldPrice;


    @FindBy(xpath = "//span[@class='price-percent-reduction small']")
    private WebElement discount;

    @FindBy(xpath = "//p[@class='cart_navigation clearfix']/a[@title ='Proceed to checkout']")
    private WebElement proceedToCheckout;

    @FindBy(xpath = "//td[@class='cart_total']/span[@class='price']")
    private List<WebElement> listOfPriceOfProductsInCart;

    @FindBy(xpath = "//td[@class='cart_total']/span[@class='price']")
    private WebElement pricetest;

    @FindBy(xpath = "//i[@class='icon-trash']")
    private List<WebElement> listOfTrashOfProductsInCart;


    public double returnPriceProductInCart(int index){
        new WebDriverWait(driver, 10).until(ExpectedConditions.
                visibilityOf(proceedToCheckout));
        String priceProduct = listOfPriceOfProductsInCart.get(index).getText();

        double price = Double.parseDouble(priceProduct.substring(1, priceProduct.length()));
        return price;
    }

    public void deleteProductFromCart(int index){
        listOfTrashOfProductsInCart.get(index).click();
    }

    public String returnAmountProductsInCart(){
        String quantityString = productsQuantity.getText();
        int element = quantityString.indexOf(' ');

        return quantityString.substring(0, element) ;
    }

    public Double returnTotalAmountOfProducts(){
        String priceProduct1= priceFirstProduct.getText();
        String priceProduct2= priceSecondProduct.getText();
        double price1 = Double.parseDouble(priceProduct1.substring(1));
        double price2 = Double.parseDouble(priceProduct2.substring(1));
        double sum = price1+price2;
        return sum;
    }

    public Double returnPriceWithDiscount(){
        String oldPriceAmount= oldPrice.getText();
        String discountAmount= discount.getText();
        double oldPriceAmountDouble = Double.parseDouble(oldPriceAmount.substring(1));
        int start = discountAmount.indexOf('-');
        int end = discountAmount.indexOf('%');
        int discountAmountInt = Integer.parseInt(discountAmount.substring(start+1, end));
        double amountWithDiscount = oldPriceAmountDouble*(100-discountAmountInt)/100;
        double newDouble = new BigDecimal(amountWithDiscount).setScale(3, RoundingMode.UP).doubleValue();
        return newDouble;
    }

    public void clickProceedToCheckOut(){
        proceedToCheckout.click();
    }


}
