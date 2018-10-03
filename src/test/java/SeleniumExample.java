import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumExample {

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
    public void verifyRegistrationValidationDDLists(){
        //test data
        String expectedMessage = "There is 1 error";
        String userEmail = "galina_ch@ukr.net";
        String userName = "Galyna";
        String userSurname = "Baranets";
        String userPass = "password";
        String userAddr = "Addr 1, ap.111";
        String userCity = "Kyiv";
        String userPost = "11111";
        String userMobile = "0981111111";

        //click Sign In
        clickLinkByXpath("//a[@class = 'login']");

        enterUserInfo("email_create", userEmail);
        clickButtonByID("SubmitCreate");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //fill in user data
        enterUserInfo("customer_firstname", userName);
        enterUserInfo("customer_lastname", userSurname);
        enterUserInfo("email", userEmail);
        enterUserInfo("passwd", userPass);
        enterUserInfo("firstname", userName);
        enterUserInfo("lastname", userSurname);
        enterUserInfo("address1", userAddr);
        enterUserInfo("city", userCity);
        enterUserInfo("postcode", userPost);
        enterUserInfo("phone_mobile", userMobile);
        enterUserInfo("alias", userAddr);

        //click Register
        clickButtonByID("submitAccount");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //check error message
        String actualMessage = getText("//div[@class = 'alert alert-danger']/p");
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    private String getText(String fieldID) {
        WebElement selectField = driver.findElement(By.xpath(fieldID));
        return selectField.getText();
    }

    private void clickButtonByID(String fieldID) {
        WebElement registerButton = driver.findElement(By.id(fieldID));
        registerButton.click();
    }

    private void enterUserInfo(String fieldID, String fieldValue) {
        WebElement editField = driver.findElement(By.id(fieldID));
        editField.clear();
        editField.sendKeys(fieldValue);
    }

    private void clickLinkByXpath(String fieldID) {
        WebElement signInLink = driver.findElement(By.xpath(fieldID));
        signInLink.click();
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


        //Delete product from Cart
        deleteProductFromCart();

        checkCartIsEmptyAfterDeletingProduct();

    }

    private void inputIntoSearchField(String searchCriteria) {
        enterUserInfo("search_query_top", searchCriteria);
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

    // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        /*
        WebElement dd = driver.findElement()
        Select value = new Select(dd);
        value.selectByIndex();
        */

    @Test
    public void verifyThatProductPriceDisplayedInDemoSession(){
        String expectedPrice = "$27.00";

        inputIntoSearchField("Blouse");
        clickSubmitSearch();
        clickListView();
        clickMore();
        String actualPrice = getProductPrice().getText();

        Assert.assertEquals(expectedPrice, actualPrice);

    }

    private WebElement getProductPrice() {
        return driver.findElement(By.id("our_price_display"));
    }






    @Test
    public void verifyCartInfo(){

        WebElement cartButton = driver.findElement(By.xpath("//a[@title = \"View my shopping cart\"]"));
        cartButton.click();

        //check order of steps
        List <WebElement> orderSteps = driver.findElements(By.xpath("//*[@id=\"order_step\"]//span"));
        List <String> actualOrders = new ArrayList<String>();
        for (WebElement orderStep: orderSteps
             ) {
            actualOrders.add(orderStep.getText());
        }

        List <String> expectedOrders = Arrays.asList("01. Summary", "02. Sign in", "03. Address", "04. Shipping", "05. Payment");

        Assert.assertTrue(expectedOrders.equals(actualOrders));

        //check text for empty cart
        WebElement  checkTextEmptyCart = driver.findElement(By.xpath("//p[@class = \"alert alert-warning\"]"));
        Assert.assertEquals("Your shopping cart is empty.", checkTextEmptyCart.getText());
    }

    @After
    public void stop(){
        driver.close();
    }
}