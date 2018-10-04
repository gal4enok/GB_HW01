import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutentificationPage;
import pages.NavigationPage;
import data.RegistrationDataProvider;

public class RegistrationTestNegativeDataProvider extends BaseTest{
    private NavigationPage navigationPage;
    private AutentificationPage autentificationPage;

    @Test(dataProvider = "RegistrationNegative", dataProviderClass = RegistrationDataProvider.class)
    public void registrationWithIncorrectCredentials(String email, String message) {
        navigationPage = new NavigationPage(driver);
        navigationPage.openSignInPage();
        autentificationPage = new AutentificationPage(driver);
        autentificationPage.createAnAccount(email);
        Assert.assertEquals(message,autentificationPage.getValidationMessage());
    }
}
