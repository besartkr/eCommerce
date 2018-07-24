
package steps;

import Base.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ECommerceLoginPage;
import pages.ECommercePageWishPage;


public class ECommerceWishSteps extends BaseUtil {

    private BaseUtil base;

    public ECommerceWishSteps(BaseUtil webDriver) {
        this.base = webDriver;
    }


    @Given("^I navigate to the WishList Page$")
    public void iNavigateToTheWishListPage() throws Throwable {
        ECommerceLoginPage page = new ECommerceLoginPage(base.webDriver);
        page.loginLink();
        page.loginEmail();
        page.loginPassword();
        page.loginSubmit();


    }

    @When("^I add items to my WishList$")
    public void iAddItemsToMyWishList() throws Throwable {
        ECommercePageWishPage page = new ECommercePageWishPage(base.webDriver);
        page.wishListPage();
        page.wishListTable();

    }

    @Then("^I will see list of WishList items on my WishList table$")
    public void iWillSeeListOfWishListItemsOnMyWishListTable() throws Throwable {
        ECommercePageWishPage page = new ECommercePageWishPage(base.webDriver);

        page.wishListPage();
        page.wishListTable();
    }

    @When("^I increase the product quantity To 10$")
    public void iIncreaseTheProductQuantityTo10() throws Throwable {
        ECommercePageWishPage page = new ECommercePageWishPage(base.webDriver);
        page.wishListPage();
        page.wishListTable();
        page.orderDetail();
        page.orderDetailQty();
    }

    @Then("^the new quantity will be saved and displayed$")
    public void theNewQuantityWillBeSavedAndDisplayed() throws Throwable {
        ECommercePageWishPage page = new ECommercePageWishPage(base.webDriver);
        page.assertNewQty();
    }

    @When("^I amend the priority of the order$")
    public void iAmendThePriorityOfTheOrder() throws Throwable {
        ECommercePageWishPage page = new ECommercePageWishPage(base.webDriver);
        iAddItemsToMyWishList();
        page.orderDetail();
        page.amendPriority();

    }

    @Then("^the new priority will be displayed on the order$")
    public void theNewPriorityWillBeDisplayedOnTheOrder()  {
        ECommercePageWishPage page = new ECommercePageWishPage(base.webDriver);

        page.assertPriority();
    }
}