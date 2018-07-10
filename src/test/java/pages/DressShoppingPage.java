package pages;

import Base.BaseUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DressShoppingPage extends BaseUtil {

    public DressShoppingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /*
    Contact us selectors
     */

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]")
    WebElement DressesSelector;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a")
    WebElement CasualDressSelector;

    @FindBy(css = "[class='heading-counter']")
    WebElement DressExists;


    public void DressSelector() {
        DressesSelector.click();
        Assert.assertEquals("Dresses - My Store", webDriver.getTitle());

    }

    public void CasualDressSelector() {
        WebDriverWait wait = new WebDriverWait(webDriver, 3);

        Actions action = new Actions(webDriver);
        action.moveToElement(DressesSelector).perform();
        wait.until(ExpectedConditions.visibilityOf(CasualDressSelector));
        action.click(CasualDressSelector).perform();
        Assert.assertEquals("Casual Dresses - My Store", webDriver.getTitle());


    }


    public boolean VerifyCasualDress() {


        Boolean isDressPresent = webDriver.findElements(By.cssSelector("[class='heading-counter']")).size() != 0;
        if (isDressPresent == true) {

            return true;
        } else {

         return false;
        }
    }
}











