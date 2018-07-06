
package steps;

import Base.BaseUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.PracticeContactUSPage;
import pages.PracticeLoginPage;
import pages.PracticePageWishPage;
import org.junit.Test;


public class PracticeWishPage extends BaseUtil {

    private BaseUtil base;

    public PracticeWishPage(BaseUtil webDriver) {
        this.base = webDriver;
    }




    @Given("^I navigate to the WishList Page$")
    public void iNavigateToTheWishListPage() throws Throwable {
        PracticeLoginPage page = new PracticeLoginPage(base.webDriver);
        page.loginLink();
        page.loginEmail();
        page.loginPassword();
        page.loginSubmit();


    }

    @When("^I add items to my WishList$")
    public void iAddItemsToMyWishList() throws Throwable {
        PracticePageWishPage page = new PracticePageWishPage(base.webDriver);
        page.wishListPage();
        page.wishListTable();

    }

    @Then("^I will see list of WishList items on my WishList table$")
    public void iWillSeeListOfWishListItemsOnMyWishListTable() throws Throwable {
        PracticePageWishPage page = new PracticePageWishPage(base.webDriver);

       page.wishListPage();
        page.wishListTable();
    }

    @When("^I increase the product quantity To 10$")
    public void iIncreaseTheProductQuantityTo10() throws Throwable {
        PracticePageWishPage page = new PracticePageWishPage(base.webDriver);
        page.wishListPage();
        page.wishListTable();
        page.orderDetail();
    }

    @Then("^the new quantity will be saved and displayed$")
    public void theNewQuantityWillBeSavedAndDisplayed() throws Throwable {
        PracticePageWishPage page = new PracticePageWishPage(base.webDriver);
    page.updatedQty();
    }
}