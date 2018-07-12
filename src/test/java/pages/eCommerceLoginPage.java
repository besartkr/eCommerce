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


public class eCommerceLoginPage extends BaseUtil {

    public eCommerceLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /*
    Login selectors
     */
    @FindBy(css = "[class='login']")
    WebElement loginSelector;

    @FindBy(name = "email")
    WebElement emailAddress;

    @FindBy(name = "passwd")
    WebElement password;

    @FindBy(name = "SubmitLogin")
    WebElement submitLogin;

    /*
      Actions action = new Actions(webDriver);
            action.moveToElement(MenuTab).perform();
            Thread.sleep(2000);
            action.click(MenuTabServicDirectory).perform();
     */
    public void loginLink()  {

        loginSelector.click();
        Assert.assertEquals("Login - My Store", webDriver.getTitle());

        ;

    }

    public WebElement loginEmail() throws Exception {
        Properties prop = new Properties();
//        FileInputStream file = new FileInputStream("C:\\Users\\besart.kryeziu\\Desktop\\myFirst\\src\\test\\java\\pages\\datadriven.properties");
        FileInputStream file = new FileInputStream("C:\\eCommerce\\src\\test\\java\\pages\\datadriven.properties");

        prop.load(file);

        emailAddress.sendKeys(prop.getProperty("loginEmail"));

        return emailAddress;

    }

    public WebElement loginPassword() throws Exception {
        Properties prop = new Properties();
     //   FileInputStream file = new FileInputStream("C:\\Users\\besart.kryeziu\\Desktop\\myFirst\\src\\test\\java\\pages\\datadriven.properties");
        FileInputStream file = new FileInputStream("C:\\eCommerce\\src\\test\\java\\pages\\datadriven.properties");

        prop.load(file);

        password.sendKeys(prop.getProperty("password"));
        return password;
    }


    public void loginSubmit() {
        submitLogin.click();
        Assert.assertEquals("My account - My Store", webDriver.getTitle());
    }




}








