package pages;

import Base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Karthik on 10/25/2016.
 */
public class LoginPage extends BaseUtil {


    public LoginPage (WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }




    @FindBy(how = How.NAME, using = "txtUsername")
    public WebElement txtUserName;



    @FindBy(how = How.NAME, using = "txtPassword")
    public WebElement txtPassword;

    @FindBy(how = How.ID, using = "btnLogin")
    public WebElement btnLogin;

    @FindBy(how = How.ID, using = "welcome")
    public WebElement welcomeMessage;

    @FindBy (how = How.CSS, using = "[href='/index.php/auth/logout']")
    public WebElement logout;


    public void Login(String userName, String password) {
        txtUserName.sendKeys ( userName );
        txtPassword.sendKeys ( password );
    }

    public void ClickLogin() {
        btnLogin.click ();
    }


    public void logout() throws InterruptedException {

       welcomeMessage.click ();
        Thread.sleep ( 200 );
        logout.click ();

        
    }
}