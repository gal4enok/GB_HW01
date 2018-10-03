package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogFilterPage {
    public WebDriver driver;

    //page factory
    public CatalogFilterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='layered_id_attribute_group_3']")
    private WebElement sizeL;

    public void selectSizeL(){
        sizeL.click();
    }
}
