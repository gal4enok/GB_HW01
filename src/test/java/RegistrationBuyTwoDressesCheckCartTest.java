import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.util.concurrent.TimeUnit;

public class RegistrationBuyTwoDressesCheckCartTest {

    WebDriver driver;
    private NavigationPage navigationPage;
    private CreateAnAccountPage createAnAccountPage;
    private RegistrationPage registrationPage;
    private ProductsListPage productsListPage;
    private CatalogFilterPage catalogFilterPage;
    private AddToCartPage addToCartPage;
    private CartSummaryPage cartPage;
    private CartAddressPage cartAddressPage;
    private CartShippingPage cartShippingPage;

    @BeforeMethod
    public void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void verifyRegistrationAddTwoProductsCheckAmounts(){
        //test data
        String userEmail = "test11@gb.ua";
        String userName = "galyna";
        String userSurname = "garanets";
        String userCompany = "QACompany";
        String userPass = "password";
        String userBDDay = "2";
        int userBDMonth = 2;
        String userBDYear = "2000";
        String userAddr = "Addr 1, ap.111";
        String userCity = "Kyiv";
        int userState = 3;
        String userStateName = "Arizona";
        String userPost = "11111";
        String userMobile = "0981111111";
        String expectedUser = userName + " "+ userSurname;
        String expectedAmountOfProducts = "2";
        Double expectedPriceOfTwoProducts = 42.4;
        Double expectedPriceWithDiscount = 16.4;


        //1. Register new user
        navigationPage = new NavigationPage(driver);
        navigationPage.openSignInPage();

        createAnAccountPage = new CreateAnAccountPage(driver);
        createAnAccountPage.inputEmail(userEmail);
        createAnAccountPage.clickCreateAnAccountButton();

        registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegistrationForm(userEmail, userName, userSurname, userCompany, userPass, userBDDay,
                userBDMonth, userBDYear, userAddr, userCity, userState, userPost, userMobile);
        registrationPage.clickRegister();


        //check user is registered
        String actualUser = navigationPage.getTextUserIsLoggedIn();
        Assert.assertEquals(expectedUser, actualUser);

        //2. select Dresses menu
        navigationPage.selectDressesMenu();

        //3. Click list View
        productsListPage = new ProductsListPage(driver);
        productsListPage.selectListView();

        //4. Select sizeL
        catalogFilterPage = new CatalogFilterPage(driver);
        catalogFilterPage.selectSizeL();

        //5. Sort by Prise Lowest
        productsListPage.sortBy("price:asc");

        //6. Select first 2 dresses
        productsListPage.addToCartProducts(0);

        addToCartPage = new AddToCartPage(driver);
        addToCartPage.clickContinueShopping();

        productsListPage.addToCartProducts(1);
        addToCartPage.clickContinueShopping();

        //7. View shopping cart
        navigationPage.vieMyShoppingCart();

        //9. Check Total Products
        cartPage = new CartSummaryPage(driver);
        String actualAmountOfProducts = cartPage.returnAmountProductsInCart();
        Assert.assertEquals(expectedAmountOfProducts, actualAmountOfProducts);

        Double actualPriceOfTwoProducts = cartPage.returnTotalAmountOfProducts();
        Assert.assertEquals(expectedPriceOfTwoProducts, actualPriceOfTwoProducts);

        //10. Check discount is correct
        Double actualPriceWithDiscount = cartPage.returnPriceWithDiscount();
        Assert.assertEquals(expectedPriceWithDiscount, actualPriceWithDiscount);

        //11.Перейти в Address - проверить Billing Address
        cartPage.clickProceedToCheckOut();
        cartAddressPage = new CartAddressPage(driver);
        String expectedUserFullName = cartAddressPage.getUserFullName();
        String actualUserFullName = userName + " " + userSurname;
        Assert.assertEquals(expectedUserFullName, actualUserFullName);

        String expectedUserAddr = cartAddressPage.getUserAddress();
        String actualUserAddr = userAddr;
        Assert.assertEquals(expectedUserAddr, actualUserAddr);

        String expectedUserCityStatePost = cartAddressPage.getUserCityStatePost();
        String actualUserCityStatePost = userCity + ", " + userStateName + " " + userPost;
        Assert.assertEquals(expectedUserCityStatePost, actualUserCityStatePost);

        String expectedUserCountry = cartAddressPage.getUserCountry();
        String actualUserCountry = "United States";
        Assert.assertEquals(expectedUserCountry, actualUserCountry);

        String expectedUserMobile = cartAddressPage.getMobile();
        String actualUserMobile = userMobile;
        Assert.assertEquals(expectedUserMobile, actualUserMobile);


        //12.Перейти в Shipping
        cartAddressPage.clickProceedToCheckOut();

        cartShippingPage = new CartShippingPage(driver);
        //Активировать “I agree ...”
        cartShippingPage.clickIAgreeOnShipping();

        //14.Перейти на страницу Payment
        cartShippingPage.clickProceedToCheckOut();

        //Сравнить что значения в блоке Payment соответствуют значениям на Cart  Summary
        cartPage = new CartSummaryPage(driver);
        actualPriceOfTwoProducts = cartPage.returnTotalAmountOfProducts();
        Assert.assertEquals(expectedPriceOfTwoProducts, actualPriceOfTwoProducts);

    }

    @AfterMethod
    public void stop(){
        driver.close();
    }
}
