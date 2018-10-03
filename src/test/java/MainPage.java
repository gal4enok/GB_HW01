public class MainPage {

    //Your Personal Info section
    public static final String GenderMrXPath = "//label[@for=\'id_gender1\']'";
    public static final String GenderMrCSS = "label[for='id_gender1']";

    public static final String GenderMrsXPath = "//label[@for=\'id_gender2\']'";
    public static final String GenderMrsCSS = "label[for='id_gender2']";

    public static final String FirstNameXPath = "//input[@id='customer_firstname']";
    public static final String FirstNameCSS = "input[id='customer_firstname']";

    public static final String LastNameXPath = "//input[@id='customer_lastname']";
    public static final String LastNameCSS = "input[id='customer_lastname']";

    public static final String EmailXPath = "//input[@id='email']";
    public static final String EmailCSS = "input[id='email']";

    public static final String PassXPath = "//input[@id='passwd']";
    public static final String PassCSS = "input[id='passwd']";

    //date of birth - days
    public static final String DOBDaysDDXPath = "//select[@id='days']";
    public static final String DOBDaysDDCSS = "select[id='days']";
    //5 in days dd
    public static final String DOBDays5DDXPath = "//select[@id='days']/option[6]";
   // #push > article:nth-child(1) > div

    //date of birth - month
    public static final String DOBMonthDDXPath = "//select[@id='months']";
    public static final String DOBMonthDDCSS = "select[id='months']";
    //February in dd
    public static final String DOBMonthFebruaryDDXPath = "//select[@id='months']/option[3]";

    //date of birth - years
    public static final String DOBYearDDXPath = "//select[@id='years']";
    public static final String DOBYearDDCSS = "select[id='years']";
    //1990 in Years dd
    public static final String DOBYear1982DDXPath = "//select[@id='years']/option[30]";

    public static final String NewsletterCheckboxXPath = "//input[@id='newsletter']";
    public static final String NewsletterCheckboxCSS = "input[id='newsletter']";

    public static final String SpecialOfferCheckboxXPath = "//input[@id='optin']";
    public static final String SpecialOfferCheckboxCSS = "input[id='optin']";



    //Your Address section
    public static final String AddressFirstNameXPath = "//input[@id='firstname']";
    public static final String AddressFirstNameCSS = "input[id='firstname']";

    public static final String AddressLastNameXPath = "//input[@id='lastname']";
    public static final String AddressLastNameCSS = "input[id='lastname']";

    public static final String AddressCompanyXPath = "//input[@id='company']";
    public static final String AddressCompanyCSS = "input[id='company']";

    public static final String AddressAddr1XPath = "//input[@id='address1']";
    public static final String AddressAddr1CSS = "input[id='address1']";

    public static final String AddressAddr2XPath = "//input[@id='address2']";
    public static final String AddressAddr2CSS = "input[id='address2']";

    public static final String AddressCityXPath = "//input[@id='city']";
    public static final String AddressCityCSS = "input[id='city']";

    //State
    public static final String AddressStateDDXPath = "//select[@id='id_state']";
    public static final String AddressStateDDCSS = "select[id='id_state']";
    //Washington in State dd
    public static final String AddressStateWashingtonXPath = "//select[@id='id_state']/option[51]";

    public static final String AddressPostcodeXPath = "//input[@id='postcode']";
    public static final String AddressPostcodeCSS = "input[id='postcode']";

    //country dd
    public static final String AddressCountryDDXPath = "//select[@id='id_country']";
    public static final String AddressCountryDDCSS = "select[id='id_country']";
    //US in country dd
    public static final String AddressCountryUSXPath = "//select[@id='id_country']/option[2]";

    public static final String AddressAddInfoXPath = "//p[@class='textarea form-group']//textarea";
    public static final String AddressAddInfoCSS = "textarea[class='form-control']";

    public static final String AddressPhoneXPath = "//input[@id='phone']";
    public static final String AddressPhoneCSS = "input[id='phone']";

    public static final String AddressMobileXPath = "//input[@id='phone_mobile']";
    public static final String AddressMobileCSS = "input[id='phone_mobile']";

    public static final String AddressAliasXPath = "//input[@value='My address']";
    public static final String AddressAliasCSS = "input[value='My address']";


    //Submit Button
    public static final String SubmitButtonXPath = "//button[@id='submitAccount']";
    public static final String SubmitButtonCSS = "button[id='submitAccount']";


}
