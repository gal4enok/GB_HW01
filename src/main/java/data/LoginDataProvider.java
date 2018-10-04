package data;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider
    public Object[][] loginExistedUser(){
        return new Object[][]{
                {"galina_ch@ukr.net", "", "Password is required."},
                {"", "", "An email address required."},
                {"", "password", "An email address required."}
        };
    }

}

