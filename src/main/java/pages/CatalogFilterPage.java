package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogFilterPage {
    public WebDriver driver;

    //page factory
    public CatalogFilterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='layered_id_attribute_group_3']")
    private WebElement sizeL;

    @FindBy(xpath = "//div[@class='ui-slider-range ui-widget-header ui-corner-all']")
    private WebElement rangeSlider;

    @FindBy(xpath = "//div[@class='layered_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']/a[1]")
    private WebElement rangeLeftCorner;

    @FindBy(xpath = "//div[@class='layered_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']/a[2]")
    private WebElement rangeRightCorner;

    public void selectSizeL(){
        sizeL.click();
    }

    public void selectRange(int start, int end){
        int width=rangeSlider.getSize().getWidth();
        int movesForOne = (int) (width/(53-16)); //7;
        int movesToStart = ((start-16)*(movesForOne+1))-1;
        int movesToEnd = ((53-end)*movesForOne);

        Actions move = new Actions(driver);

        move.dragAndDropBy(rangeLeftCorner, movesToStart, 0).build().perform();
        move.dragAndDropBy(rangeRightCorner, - movesToEnd, 0).build().perform();

        new WebDriverWait(driver, 10).until(ExpectedConditions.
                visibilityOfElementLocated(By.cssSelector(".product_list > p")));
        new WebDriverWait(driver, 10).until(ExpectedConditions.
                invisibilityOfElementLocated(By.cssSelector(".product_list > p")));
    }
}
