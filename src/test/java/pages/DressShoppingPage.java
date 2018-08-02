package pages;

import Base.BaseUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.ECommerceContactUsSteps;


public class DressShoppingPage extends BaseUtil {

    public DressShoppingPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /*
    Contact us selectors
     */

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]")
    WebElement DressesSelector;

    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a")
    WebElement CasualDressSelector;

    @FindBy(css = "[class='heading-counter']")
    WebElement DressExists;

    /* Add Casual dress to Basket */

    @FindBy(css = "[class='available-now']")
    WebElement inStock;

    @FindBy(css = "[class='button ajax_add_to_cart_button btn btn-default']")
    WebElement addToCart;

    @FindBy(css = "[class='icon-ok']")
    WebElement addToCartValidation;

    @FindBy(css = "[class='ajax_cart_no_product']")
    WebElement checkIframe;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
    WebElement cartTable;

    @FindBy(css = "[class='cross']")
    WebElement closeAddPrduct;

    @FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/span[1]")
    WebElement cartSize;

    @FindBy(id = "button_order_cart")
    WebElement buttonOrderCart;

    /*
    ProcessToCheckOut
     */
    @FindBy(css = "[class='button btn btn-default standard-checkout button-medium']")
    WebElement ProceedToCheckOut;


    @FindBy(css = "[class='icon-lock left']")
    WebElement checkifSignedIn;

    @FindBy(css = "step_current third")
    WebElement step03Address;

    @FindBy(name = "processAddress")
    WebElement step04Shipping;

    @FindBy(css = "[class='step_current last']")
    WebElement step05Payment;


    @FindBy(id = "addressesAreEquals")
    WebElement addressNotEquals;
    /*
    Your Delivery Address
     */

    @FindBy(css = "[class='address item box'] [class='address_firstname address_lastname']")
    WebElement DevAddressfirstName;

    @FindBy(css = "[class='address item box'] [class='address_address1 address_address2']")
    WebElement DevAddress2ndLine;


    @FindBy(css = "[class='address item box'] [class='address_city address_state_name address_postcode']")
    WebElement DevAddressCity;


    @FindBy(css = "[class='address item box'] [class='address_country_name']")
    WebElement DevAddresCountry;

    @FindBy(css = "[class='address item box'] [class='address_phone_mobile']")
    WebElement DevAddressHomeNum;

    /* Your payment Address */

    @FindBy(css = "[class='address item box'] [class='address_firstname address_lastname']")
    WebElement BillAddressfirstName;

    @FindBy(css = "[class='address item box'] [class='address_address1 address_address2']")
    WebElement BillAddress2ndLine;

    @FindBy(css = "[class='address item box'] [class='address_city address_state_name address_postcode']")
    WebElement BillAddressCity;

    @FindBy(css = "[class='address item box'] [class='address_country_name']")
    WebElement BillAddresCountry;


    @FindBy(css = "[class='address item box'] [class='address_phone_mobile']")
    WebElement BillAddressHomeNum;


    /*
    Shipping
     */

    @FindBy(id = "cgv")
    WebElement TermsConditions;

    public void DressSelector() {
        DressesSelector.click();
        Assert.assertEquals("Dresses - My Store", webDriver.getTitle());

    }

    public void CasualDressSelector() {
        WebDriverWait wait = new WebDriverWait(webDriver, 3);

        Actions action = new Actions(webDriver);
        action.moveToElement(DressesSelector).perform();
        wait.until(ExpectedConditions.visibilityOf(CasualDressSelector));
        action.click(CasualDressSelector).perform();
        Assert.assertEquals("Casual Dresses - My Store", webDriver.getTitle());


    }


    public boolean VerifyCasualDress() {


        Boolean isDressPresent = webDriver.findElements(By.cssSelector("[class='heading-counter']")).size() != 0;
        if (isDressPresent == true) {

            return true;
        } else {

            return false;
        }
    }

    public void addtoBasket() {

        Boolean inStockSelector = inStock.isDisplayed();

        WebDriverWait wait = new WebDriverWait(webDriver, 3);
        if (inStockSelector == true) {
            Actions action = new Actions(webDriver);
            action.moveToElement(addToCart).perform();
            action.click(addToCart).perform();

            wait.until(ExpectedConditions.visibilityOf(addToCartValidation));
            Assert.assertTrue(addToCartValidation.isDisplayed());

        }
    }

    public void iframeDisplay() {

        Boolean cartTable1 = cartTable.isDisplayed();
        if (cartTable1 == true) {

            closeAddPrduct.click();

        }

    }

    public void placeOrder() {
        WebDriverWait wait = new WebDriverWait(webDriver, 3);

        String cartQty = cartSize.getText();

        int i = Integer.parseInt(cartQty);

        if (i <= 0) {
            System.out.println("Basket Quantity is: " + i);

        } else {

            Actions action = new Actions(webDriver);
            action.moveToElement(cartTable).perform();
            wait.until(ExpectedConditions.visibilityOf(buttonOrderCart));
            buttonOrderCart.click();
        }
    }


    public void SummaryAndSignIn() throws Throwable {
        WebDriverWait wait = new WebDriverWait(webDriver, 2);
        wait.until(ExpectedConditions.visibilityOf(ProceedToCheckOut));

        ProceedToCheckOut.click();
        Boolean SignedInDisplay = checkifSignedIn.isDisplayed();


        if (SignedInDisplay == true) {

            ECommerceContactUsSteps page = new ECommerceContactUsSteps(this);
            page.iLoginAsARegisterUser();
            page.iWillBeTakenToMyAccountPage();


        }

    }


    public void addressStage() {
        if (step03Address.isDisplayed()) {


        }

    }

    public boolean compareAddressMatch() {


        if (addressNotEquals.isSelected()) {
            addressNotEquals.click();
        }

        String DevFirstName = DevAddressfirstName.getText();
        String DevAdrdressLine = DevAddress2ndLine.getText();
        String DevadrdresCountry = DevAddresCountry.getText();
        String DevhomeNum = DevAddressHomeNum.getText();


        String BillfirstName = BillAddressfirstName.getText();
        String BillAdrdressLine = BillAddress2ndLine.getText();
        String BilladrdresCountry = BillAddresCountry.getText();
        String BillhomeNum = BillAddressHomeNum.getText();


        if (!DevFirstName.equals(BillfirstName)) {
            return false;
        }
        if (!DevAdrdressLine.equals(BillAdrdressLine)) {
            return false;
        }

        if (!DevadrdresCountry.equals(BilladrdresCountry)) {
            if (!DevhomeNum.equals(BillhomeNum)) ;

        }
        return true;

    }

    public void goToShipping() {
        WebDriverWait wait = new WebDriverWait(webDriver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(step04Shipping));


        step04Shipping.click();


    }

    public void ShippingAddress() {


        if (!TermsConditions.isSelected()) {
            TermsConditions.click();
        }
        ProceedToCheckOut.click();
    }

    public void paymentPage() {

        Assert.assertTrue(step05Payment.isDisplayed());
    }
}











