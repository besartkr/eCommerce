package pages;

import Base.BaseUtil;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class PracticeContactUSPage extends BaseUtil {

    public PracticeContactUSPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(id = "contact-link")
    WebElement contactLink;


    public void contactUs() {
        contactLink.click();
        Assert.assertTrue(webDriver.getTitle().contains("Contact us - My Store"));

    }


}
