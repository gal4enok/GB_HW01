import org.testng.annotations.Test;
import pages.*;

public class HW8AddDressesToCartRemoveDressWithHigherPriceTest extends BaseTest{
    private NavigationPage navigationPage;
    private CatalogFilterPage catalogFilterPage;
    private ProductsListPage productsListPage;
    private AddToCartPage addToCartPage;
    private CartSummaryPage cartSummaryPage;

    @Test
    public void verifyAddDressesToCartRemoveDressWithHigherPrice () {
        navigationPage = new NavigationPage(driver);
        navigationPage.selectDressesMenu();


        catalogFilterPage = new CatalogFilterPage(driver);
        catalogFilterPage.selectRange(25,45);

        productsListPage = new ProductsListPage(driver);
        productsListPage.selectListView();

        int amountFromSearch = productsListPage.getAmountOfProducts();

        for (int i = 0; i <amountFromSearch; i++) {
            String nameOfProduct = productsListPage.getNameOfProduct(i);
            if (nameOfProduct.contains("Dress")){
                productsListPage.addToCartProducts(i);
                addToCartPage = new AddToCartPage(driver);
                addToCartPage.clickContinueShopping();
            }
        }


        // View shopping cart
        navigationPage.vieMyShoppingCart();

        //Check Total Products
        cartSummaryPage = new CartSummaryPage(driver);
        String actualAmountOfProducts = cartSummaryPage.returnAmountProductsInCart();
        int amountPfProductsInt = Integer.parseInt(actualAmountOfProducts);

        double lowestPrice = cartSummaryPage.returnPriceProductInCart(0);
        int lowestPriceIndex = 0;
        for (int i = 1; i <amountPfProductsInt; i++) {
           double price = cartSummaryPage.returnPriceProductInCart(i);
            if (price < lowestPrice){
                cartSummaryPage.deleteProductFromCart(lowestPriceIndex);
                lowestPriceIndex = i;
                lowestPrice = cartSummaryPage.returnPriceProductInCart(i);
            } else {
                cartSummaryPage.deleteProductFromCart(i);
            }
        }

        cartSummaryPage.clickProceedToCheckOut();
    }
}
