package data;

import org.testng.annotations.DataProvider;

public class RegistrationDataProvider {

    @DataProvider
    public Object[][]  registerNewUser(){
        return new Object[][]{
                {"galina_ch@ukr.net", "", " fdas"},
                {"", "", " fdas"},
                {"", "password", " fdas"}
        };
    }


}
