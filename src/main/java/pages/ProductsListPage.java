package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductsListPage {
    public WebDriver driver;
    private AddToCartPage addToCartPage;

    public ProductsListPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='icon-th-list']")
    private WebElement listView;

    @FindBy(id = "selectProductSort")
    private WebElement sortByDDList;

    @FindBy(xpath = "//div/div/div[3]/div/div[2]/a[@title='Add to cart']")
    private List <WebElement> listOfProductsAddToCart;

    @FindBy(xpath = "//div/div/div[2]/h5")
    private List <WebElement> listOfProductsName;

    @FindBy(xpath = "//div[@class='product-count']")
    private WebElement amountOfProductsName;


    @FindBy(xpath = "//ul[@class='product_list row list']/li[2]/div/div/div[3]/div/div[2]/a")
    private WebElement secondProduct;

    @FindBy(xpath = "//ul[@class='product_list row list']/li/div/div/div[3]/div/div[2]/a")
    private WebElement firstProduct;


    public void selectListView(){
        listView.click();
    }

    public void sortBy(String value){
        Select sortBy = new Select(sortByDDList);
        sortBy.selectByValue(value);
        new WebDriverWait(driver, 10).until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector(".product_list > p")));
        new WebDriverWait(driver, 10).until(ExpectedConditions.
                invisibilityOfElementLocated(By.cssSelector(".product_list > p")));

    }
/*
    public void addToCartFirstProduct(){
        firstProduct.click();
    }
    public void addToCartSecondProduct(){
        secondProduct.click();
    }
 */

    public void addToCartProducts(int itemIndex){
        listOfProductsAddToCart.get(itemIndex).click();
    }

    public int getAmountOfProducts(){

        String amountOfProductStr = amountOfProductsName.getText();
        int startSubString = amountOfProductStr.indexOf("of ")+3;
        int endSubString = amountOfProductStr.indexOf(" items");

        String amountString = amountOfProductStr.substring(startSubString,  endSubString) ;
        return Integer.parseInt(amountString);
    }

    public String getNameOfProduct(int itemIndex){
        return listOfProductsName.get(itemIndex).getText();
    }

}
