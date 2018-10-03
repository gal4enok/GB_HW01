import model.Account;
import org.junit.Assert;
import org.junit.Test;
import pages.AutentificationPage;
import pages.MyAccountPage;
import pages.NavigationPage;

public class LoginTest extends RegistrationBuyTwoDressesCheckCartTest{

    private NavigationPage navigationPage;
    private AutentificationPage autentificationPage;
    private MyAccountPage myAccountPage;

    @Test
    public void verifyLoginWithCorrectCreds(){
        Account account= new Account();
        account.setEmail("galina_ch@ukr.net");
        account.setPassword("password");
        account.setFirstName("galyna");
        account.setLastName("baranets");

        navigationPage = new NavigationPage(driver);
        navigationPage.openSignInPage();

        autentificationPage = new AutentificationPage(driver);
        autentificationPage.
                typeEmail(account).
                typePassword(account).
                clickSignIn();

        myAccountPage = new MyAccountPage(driver);
        Assert.assertEquals(account.getFirstName() + " " + account.getLastName(),
                myAccountPage.getUserInfo());
    }
}
