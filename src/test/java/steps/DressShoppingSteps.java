
package steps;

import Base.BaseUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.DressShoppingPage;
import pages.PracticeContactUSPage;
import pages.PracticeLoginPage;


public class DressShoppingSteps extends BaseUtil {

    private BaseUtil base;

    public DressShoppingSteps(BaseUtil webDriver) {
        this.base = webDriver;
    }


    /*********************************
     *
     * Given Statements
     */
    @Given("^I navigate to Dresses page$")
    public void iNavigateToDressesPage() throws Throwable {
        DressShoppingPage page = new DressShoppingPage(base.webDriver);
        page.DressSelector();
    }

    @When("^I select a Casual Dresses$")
    public void iSelectACasualDresses() throws Throwable {
        DressShoppingPage page = new DressShoppingPage(base.webDriver);
        page.CasualDressSelector();
    }

    @Then("^list of Casual Dresses will be displayed on the page$")
    public void listOfCasualDressesWillBeDisplayedOnThePage() throws Throwable {
        DressShoppingPage page = new DressShoppingPage(base.webDriver);
        page.VerifyCasualDress();
    }
}
