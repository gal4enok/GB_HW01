import data.LoginDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutentificationPage;
import pages.NavigationPage;

public class LoginTestNegativeDataProvider extends BaseTest{

        private NavigationPage navigationPage;
        private AutentificationPage autentificationPage;

    @Test(dataProvider = "loginExistedUser", dataProviderClass = LoginDataProvider.class)
    public void loginWithIncorrectCredentials(String email, String pass, String message) {
        navigationPage = new NavigationPage(driver);
        navigationPage.openSignInPage();
        autentificationPage = new AutentificationPage(driver);
        autentificationPage.loginIntoAccount(email, pass);
        Assert.assertEquals(message,autentificationPage.getValidationMessage());
    }
}

