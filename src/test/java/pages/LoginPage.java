package pages;

import Base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BaseUtil {


    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(name = "txtUsername")
    public WebElement txtUserName;

    @FindBy(name = "txtPassword")
    public WebElement txtPassword;

    @FindBy(id = "btnLogin")
    public WebElement btnLogin;

    @FindBy(id = "welcome")
    public WebElement welcomeMessage;

    @FindBy(css = "[href='/index.php/auth/logout']")
    public WebElement logout;


    public void Login(String userName, String password) {
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
    }

    public void ClickLogin() {
        btnLogin.click();
    }


    public void logout() throws InterruptedException {

        welcomeMessage.click();
        Thread.sleep(200);
        logout.click();


    }
}