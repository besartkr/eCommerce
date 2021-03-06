
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
        page.existingJobTitles();
    }

    @And("^if the Job is not in the database table$")
    public void ifTheJobIsNotInTheDatabaseTable() throws Throwable {
        JobsPage page = new JobsPage(base.webDriver);
      //  page.addNewJob();


    }

    @When("^I enter the details of the new job$")
    public void iEnterTheDetailsOfTheNewJob() throws Throwable {
        JobsPage page = new JobsPage(base.webDriver);
        page.addNewJob();
        page.enterNewJobDetails();
    }

    @Then("^I'll update the job details have have them displayed in the database$")
    public void iLlUpdateTheJobDetailsHaveHaveThemDisplayedInTheDatabase() throws Throwable {
        JobsPage page = new JobsPage(base.webDriver);
       page.editJobTitle();
        page.confirmChanges();

    }

    @Then("^the job will be added in database$")
    public void theJobWillBeAddedInDatabase() throws Throwable {
        JobsPage page = new JobsPage(base.webDriver);
        page.assertNewJobAdded();

        }

    @When("^I delete a job title from the list$")
    public void iDeleteAJobTitleFromTheList() throws Throwable {
        JobsPage page = new JobsPage(base.webDriver);
        page.selectAndDeleteJobTitle();


    }

    @Then("^The job Title no longer exists in the database$")
    public void theJobTitleNoLongerExistsInTheDatabase() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      JobsPage page = new  JobsPage(base.webDriver);
      page.confirmChanges();

    }
}