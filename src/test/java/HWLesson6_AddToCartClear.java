import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HWLesson6_AddToCartClear {

    WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }


    @Test
    public void verifyAddProductToCartChangeQuantityCheckAmountClearCart(){
        String expectedUnitPriceInProductTable = "$27.00";
        String expectedTotalInProductTable = "$54.00";
        String expectedTotalProducts = "$54.00";
        String expectedTotalShipping = "$2.00";
        String expectedTotal = "$56.00";
        String expectedTax = "$0.00";
        String expectedTOTAL = "$56.00";


        inputIntoSearchField("Blouse");
        clickSubmitSearch();
        clickListView();
        addToCart();

        clickProceedToCheckOut();

        setQuantity(2);

        waitTableIsUpdated();

        checkAmounts(expectedUnitPriceInProductTable, expectedTotalInProductTable, expectedTotalProducts,
                expectedTotalShipping, expectedTotal, expectedTax, expectedTOTAL);


        deleteProductFromCart();

        checkCartIsEmptyAfterDeletingProduct();

    }


    private void inputIntoSearchField(String searchCriteria) {
        WebElement editField = driver.findElement(By.id("search_query_top"));
        editField.clear();
        editField.sendKeys(searchCriteria);
    }

    private void clickMore() {
        WebElement moreButton = driver.findElement(By.xpath("//a[@title='View']"));
        moreButton.click();
    }

    private void clickListView() {
        WebElement listView = driver.findElement(By.className("icon-th-list"));
        listView.click();
    }

    private void clickSubmitSearch() {
        WebElement findButton = driver.findElement(By.name("submit_search"));
        findButton.click();
    }

    private void checkCartIsEmptyAfterDeletingProduct() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(By.className("ajax_cart_no_product")));

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    private void deleteProductFromCart() {
        WebElement trashButtonInCart = driver.findElement(By.className("icon-trash"));
        trashButtonInCart.click();
    }

    private void checkAmounts(String expectedUnitPriceInProductTable, String expectedTotalInProductTable, String expectedTotalProducts, String expectedTotalShipping, String expectedTotal, String expectedTax, String expectedTOTAL) {
        WebElement value = driver.findElement(By.xpath("//span[@id='product_price_2_7_0']/span"));
        String actualUnitPriceInProductTable = value.getText();

        Assert.assertEquals(expectedUnitPriceInProductTable, actualUnitPriceInProductTable);


        //check total in table
        value = driver.findElement(By.id("total_product_price_2_7_0"));
        String acutalTotalInProductTable = value.getText();

        Assert.assertEquals(expectedTotalInProductTable, acutalTotalInProductTable);


        //check total products
        value = driver.findElement(By.id("total_product"));
        String acutalTotalProducts = value.getText();

        Assert.assertEquals(expectedTotalProducts, acutalTotalProducts);


        //check total shipping
        value = driver.findElement(By.id("total_shipping"));
        String acutalTotalShipping = value.getText();

        Assert.assertEquals(expectedTotalShipping, acutalTotalShipping);


        //check Total
        value = driver.findElement(By.id("total_price_without_tax"));
        String acutalTotal = value.getText();

        Assert.assertEquals(expectedTotal, acutalTotal);


        //check Tax
        value = driver.findElement(By.id("total_tax"));
        String acutalTax = value.getText();

        Assert.assertEquals(expectedTax, acutalTax);


        //check TOTAL
        value = driver.findElement(By.id("total_price"));
        String acutalTOTAL = value.getText();

        Assert.assertEquals(expectedTOTAL, acutalTOTAL);
    }

    private void waitTableIsUpdated() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.textToBePresentInElementLocated(By.id("summary_products_quantity"), "2 Products"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void clickProceedToCheckOut() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new WebDriverWait(driver, 10).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Proceed to checkout']"))).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void setQuantity(Integer amount) {
        WebElement quantity = driver.findElement(By.xpath("//input [@name='quantity_2_7_0_0']"));
        quantity.clear();
        quantity.sendKeys(amount.toString());
    }

    private void addToCart() {
        driver.findElement(By.xpath("//a[@title='Add to cart']")).click();
    }

    @After
    public void stop(){
        driver.close();
    }

}
