
package steps;

import Base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AdminPage;
import pages.JobsPage;

import java.util.ArrayList;
import java.util.List;


public class JobStep extends BaseUtil {

    private BaseUtil base;

    public JobStep(BaseUtil base) {
        this.base = base;
    }


    @Given("^I navigate to the list of available jobs$")
    public void iNavigateToTheListOfAvailableJobs() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        JobsPage page = new JobsPage(base.webDriver);
        page.adminTab();
    }

    @When("^I search for existing job title$")
    public void iSearchForExistingJobTitle() throws Throwable {
        JobsPage page = new JobsPage(base.webDriver);
        page.jobTitles();
    }

    @And("^if the Job is not in the database table$")
    public void ifTheJobIsNotInTheDatabaseTable() throws Throwable {
        JobsPage page = new JobsPage(base.webDriver);
        page.addNewJob();
        page.enterNewJobDetails();

    }
}