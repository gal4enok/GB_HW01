package data;

import org.testng.annotations.DataProvider;

public class RegistrationDataProvider {
    @DataProvider
    public Object[][] RegistrationNegative(){
        return new Object[][]{
                {"galina_ch@ukr.net", "An account using this email address has already been registered. " +
                        "Please enter a valid password or request a new one."},
                {"", "Invalid email address."},
                {"galina", "Invalid email address."}
        };
    }
}
