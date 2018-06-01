package steps;

import Base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AdminPage;

import java.util.ArrayList;
import java.util.List;


public class AdminStep extends BaseUtil {

    private BaseUtil base;

    public AdminStep(BaseUtil base) {
        this.base = base;
    }


    @Given("^I navigate to the Admin tab$")
    public void iNavigateToTheAdminTab() throws Throwable {
        pages.AdminPage page = new pages.AdminPage(base.webDriver);
        page.adminTab();


    }

    @When("^I key the admin details$")
    public void iKeyTheAdminDetails(DataTable table) throws Throwable {
        AdminPage page = new AdminPage(base.webDriver);
        page.setAddNewAdmin();
        page.userrole();
        //Create an ArrayList
        List<User> users = new ArrayList<User>();
        //Store all the users
        users = table.asList(User.class);


        for (User user : users) {
            page.Management(user.employeeName, user.username, user.password, user.confirmpass);
        }
    }

    @And("^I edit my employer details on my username$")
    public void iEditMyEmployerDetailsOnMyUsername() throws InterruptedException {
        AdminPage page = new AdminPage(base.webDriver);
        page.selecttoSearch();
        page.enabletToEditDetails();
        page.ChangeEmployeDetails();
    }

    @Then("^The user Role will change from Admin to ESS$")
    public void theUseRoleWillChangeFromAdminToEss() throws Throwable {
        AdminPage page = new AdminPage(base.webDriver);

        page.saveButton();
        page.successfullySaved();
    }

    public class User {
        public String employeeName;
        public String username;
        public String password;
        public String confirmpass;
    }

    @When("^I search for an admin account$")
    public void iSearchForAnAdminAccount(DataTable table) throws Throwable {
        AdminPage page = new AdminPage(base.webDriver);
        Thread.sleep(200);
        page.searchExistingUser();

        //Create an ArrayList
        List<deleteUser> users = new ArrayList<deleteUser>();
        //Store all the users
        users = table.asList(deleteUser.class);


        for (deleteUser user : users) {
            page.deleteAdminusers(user.addUserName, user.employeeName);
        }

    }

    public class deleteUser {
        public String addUserName;
        public String employeeName;


    }

    @And("^I key the ([^\"]*) and ([^\"]*)$$")
    public void iKeyThe(String EmployeeName, String username, String password, String confirmpass) throws Throwable {


        System.out.println("EmployeeName : " + EmployeeName);
        System.out.println("Username : " + username);
        System.out.println("Password : " + password);
        System.out.println("Confirm Password " + confirmpass);


    }

    @And("^I click Save button$")
    public void iClickSaveButton() throws Throwable {
        AdminPage page = new AdminPage(base.webDriver);
        Thread.sleep(2000);
        page.saveDetails();
    }

    @Then("^I will see the details are saved in the table$")
    public void iWillSeeTheDetailsAreSavedInTheTable() throws Throwable {
        AdminPage page = new AdminPage(base.webDriver);
        Thread.sleep(200);

        page.successfullySaved();
    }

}