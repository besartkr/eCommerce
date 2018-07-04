
package steps;

import Base.BaseUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.PracticeContactUSPage;
import pages.PracticeLoginPage;


public class PracticeContactUs extends BaseUtil {

    private BaseUtil base;

    public PracticeContactUs(BaseUtil webDriver) {
        this.base = webDriver;
    }




    @Given("^I navigate to the contact us page$")
    public void iNavigateToTheContactUsPage() throws Throwable {
        PracticeContactUSPage page = new PracticeContactUSPage(base.webDriver);
       page.contactUs();

    }


    @When("^I enter the  email address, orderRef & the Message$")
    public void iEnterTheEmailAddressOrderRefTheMessage() throws Throwable {
        PracticeContactUSPage page = new PracticeContactUSPage(base.webDriver);
        page.messageDetails();

    }


    @Then("^I will get a confirmation message$")
    public void iWillGetAConfirmationMessage() throws Throwable {
        PracticeContactUSPage page = new PracticeContactUSPage(base.webDriver);
        page.sendMessage();
    }

    /*     Login page      */
    @Given("^I navigate to the Login Page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        PracticeLoginPage page = new PracticeLoginPage(base.webDriver);
        page.enterlogindetails();


    }

    @When("^I login as a register user$")
    public void iLoginAsARegisterUser() throws Throwable {
        PracticeLoginPage page = new PracticeLoginPage(base.webDriver);
        page.login();

    }

    @Then("^I will be taken to My Account page$")
    public void iWillBeTakenToMyAccountPage() throws Throwable {
        PracticeLoginPage page = new PracticeLoginPage(base.webDriver);
        page.verifyLogin();
    }
}