package pages;

import Base.BaseUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.util.Properties;


public class PracticeLoginPage extends BaseUtil {

    public PracticeLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(css = "[class='login']")
    WebElement loginSelector;


    /*
      Actions action = new Actions(webDriver);
            action.moveToElement(MenuTab).perform();
            Thread.sleep(2000);
            action.click(MenuTabServicDirectory).perform();
     */
    public void login() throws Exception {
        loginSelector.click();
        Assert.assertEquals("Login - My Store", webDriver.getTitle());

        ;
    }
}








