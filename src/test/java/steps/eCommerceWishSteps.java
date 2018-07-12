
package steps;

import Base.BaseUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.eCommerceLoginPage;
import pages.eCommercePageWishPage;


public class eCommerceWishSteps extends BaseUtil {

    private BaseUtil base;

    public eCommerceWishSteps(BaseUtil webDriver) {
        this.base = webDriver;
    }


    @Given("^I navigate to the WishList Page$")
    public void iNavigateToTheWishListPage() throws Throwable {
        eCommerceLoginPage page = new eCommerceLoginPage(base.webDriver);
        page.loginLink();
        page.loginEmail();
        page.loginPassword();
        page.loginSubmit();


    }

    @When("^I add items to my WishList$")
    public void iAddItemsToMyWishList() throws Throwable {
        eCommercePageWishPage page = new eCommercePageWishPage(base.webDriver);
        page.wishListPage();
        page.wishListTable();

    }

    @Then("^I will see list of WishList items on my WishList table$")
    public void iWillSeeListOfWishListItemsOnMyWishListTable() throws Throwable {
        eCommercePageWishPage page = new eCommercePageWishPage(base.webDriver);

        page.wishListPage();
        page.wishListTable();
    }

    @When("^I increase the product quantity To 10$")
    public void iIncreaseTheProductQuantityTo10() throws Throwable {
        eCommercePageWishPage page = new eCommercePageWishPage(base.webDriver);
        page.wishListPage();
        page.wishListTable();
        page.orderDetail();
        page.orderDetailQty();
    }

    @Then("^the new quantity will be saved and displayed$")
    public void theNewQuantityWillBeSavedAndDisplayed() throws Throwable {
        eCommercePageWishPage page = new eCommercePageWishPage(base.webDriver);
        page.assertNewQty();
    }

    @When("^I amend the priority of the order$")
    public void iAmendThePriorityOfTheOrder() throws Throwable {
        eCommercePageWishPage page = new eCommercePageWishPage(base.webDriver);
        page.amendPriority();

    }

    @Then("^the new priority will be displayed on the order$")
    public void theNewPriorityWillBeDisplayedOnTheOrder() throws Throwable {
        eCommercePageWishPage page = new eCommercePageWishPage(base.webDriver);

        page.assertPriority();
    }
}