package steps;

import Base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;


public class LoginStep extends BaseUtil {

    private BaseUtil webDriver;

    public LoginStep(BaseUtil webDriver) {
        this.webDriver = webDriver;
    }

     @Then("^I should see the welcome message$")
    public void iShouldSeeTheWelcomeMessage() throws Throwable {

        Assert.assertEquals("Its not displayed", webDriver.webDriver.findElement (By.cssSelector ("[class='panelTrigger']") ).isDisplayed(), true);
    }



    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        LoginPage page = new LoginPage (webDriver.webDriver);
        page.ClickLogin();
    }


    @When ("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
        //Create an ArrayList
        List<User> users =  new ArrayList<User>();
        //Store all the users
        users = table.asList(User.class);

        LoginPage page = new LoginPage (webDriver.webDriver);


        for (User user: users){
           page.Login(user.username, user.password);
        }
    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String userName, String password) throws Throwable {
        System.out.println("UserName is : " + userName);
        System.out.println("Password is : " + password);
    }

    @And("^I click on the log out button to logout$")
    public void iClickOnTheLogOutButtonToLogout() throws Throwable {
      LoginPage page = new LoginPage ( webDriver.webDriver);
      page.logout ();
    }


    public class User {
        public String username;
        public String password;

    }

}
