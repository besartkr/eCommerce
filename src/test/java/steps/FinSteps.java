
package steps;

import Base.BaseUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import pages.FinPage;
import pages.JobsPage;


public class FinSteps extends BaseUtil {

    private BaseUtil base;

    public FinSteps(BaseUtil base) {
        this.base = base;
    }


    @When("^I enter my login details$")
    public void iEnterMyLoginDetails() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        FinPage page = new FinPage(base.webDriver);
        page.enterLoginDetails();
    }

    @And("^I click OK button$")
    public void iClickOKButton() throws Throwable {
     FinPage page = new FinPage(base.webDriver);
     page.login();
    }

    @Then("^I should be taken the to Finance Home Page$")
    public void iShouldBeTakenTheToFinanceHomePage() throws Throwable {
      FinPage page = new FinPage(base.webDriver);
      page.assertLogin();
    }

    @Given("^I navigate to the Service Directory page$")
    public void iNavigateToTheServiceDirectoryPage() throws Throwable {
        FinPage page = new FinPage(base.webDriver);
        page.navigatetoServiceDirectory();
        page.serviceCategoryDetails();

    }

    @When("^I enter the details of the new Service Category$")
    public void iEnterTheDetailsOfTheNewServiceCategory() throws Throwable {
        FinPage page = new FinPage(base.webDriver);

        page.serviceCategoryDetails();
        page.selectApplication();
        page.brokerageList();
        page.selectBrokerage();
        page.provisionDetailView();
        page.selectProvisionDetailView();
        page.pesonalBudget();
        page.variationsAllowed();
        page.create();




    }

    @Then("^the Service Category will be available in the Service directory list$")
    public void theServiceCategoryWillBeAvailableInTheServiceDirectoryList() throws Throwable {

    }
}