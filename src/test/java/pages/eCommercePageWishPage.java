package pages;

import Base.BaseUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;


public class eCommercePageWishPage extends BaseUtil {

    public eCommercePageWishPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /*
        WishList Selectors

         */
    @FindBy(css = "[class='account']")
    WebElement MyAccount;

    @FindBy(css = "[class='lnk_wishlist']")
    WebElement MyWishList;

    @FindBy(id = "block-history")
    WebElement wishlistTable;

    @FindBy(xpath = "//*[@id=\"best-sellers_block_right\"]/div/ul/li[3]/a/img")
    WebElement productSeletor;

    @FindBy(id = "wishlist_button")
    WebElement wishListButton;

    @FindBy(css = "[class='fancybox-item fancybox-close']")
    WebElement wishListAddConnfirmationBox;


    /*
    Order Detail Table
     */
    @FindBy(xpath = "//*[@id=\"wishlist_4463\"]/td[5]/a")
    WebElement vieworderDetailLink;

    @FindBy(css = "[class='bold align_center']")
    WebElement orderQty;

    @FindBy(id = "quantity_2_7")
    WebElement orderQtyDetailTable;

    @FindBy(id = "block-order-detail")
    WebElement orderDetailTable;

    @FindBy(xpath = "//*[@id=\"wlp_2_7\"]/div/div[2]/div/div[2]/a/span")
    WebElement saveChanges;

    @FindBy(xpath = "//*[@id=\"priority_2_7\"]")
    WebElement orderPrioritySelect;

/*
  Actions action = new Actions(webDriver);
        action.moveToElement(MenuTab).perform();
        Thread.sleep(2000);
        action.click(MenuTabServicDirectory).perform();
 */


    public void wishListPage() {
        if (MyWishList.isDisplayed()) {
            MyWishList.click();
        } else if (MyAccount.isDisplayed()) {
            MyAccount.click();
            MyWishList.click();

        }


        Assert.assertEquals("My Store", webDriver.getTitle());


    }


    public void wishListTable() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 3);
        Boolean isWishListPresent = webDriver.findElements(By.id("block-history")).size() != 0;
        if (isWishListPresent == true) {


        } else {

            productSeletor.click();

            wait.until(ExpectedConditions.visibilityOf(wishListButton));


            wishListButton.click();

            wishListAddConnfirmationBox.click();
/*
} else if (productSeletor.isDisplayed()) {
            productSeletor.click();

            Thread.sleep(1000);
        }
    else if
              (wishListButton.isDisplayed()) {
            wishListButton.click();
            Thread.sleep(1000);
        }

        else if (wishListAddConnfirmationBox.isDisplayed()) {
                wishListAddConnfirmationBox.click();
 */
        }
    }

    public void orderDetail() {
        if (vieworderDetailLink.isDisplayed()) {
            vieworderDetailLink.click();
            Assert.assertTrue(orderDetailTable.isDisplayed());
        }

    }

    public void orderDetailQty() throws IOException {
        WebDriverWait wait = new WebDriverWait(webDriver, 3);
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\besart\\Desktop\\firstCommit\\src\\test\\java\\pages\\datadriven.properties");
        prop.load(file);

        String Qty = orderQty.getText();
        int i = Integer.parseInt(Qty);

        if (i <= 10)
            System.out.println("Basket Quantity is: " + i);

        else {
            wait.until(ExpectedConditions.visibilityOf(orderQtyDetailTable));
            orderQtyDetailTable.click();
        }
        wait.until(ExpectedConditions.visibilityOf(orderQtyDetailTable));

        if (orderQtyDetailTable.getText().contains("")) {
            orderQtyDetailTable.clear();
            orderQtyDetailTable.sendKeys(prop.getProperty("Qty"));

            wait.until(ExpectedConditions.visibilityOf(saveChanges));

        }


    }

    public void assertNewQty() throws IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\eCommerce\\src\\test\\java\\pages\\datadriven.properties");
        prop.load(file);

        saveChanges.click();

        String newQty = orderQty.getText();
        Assert.assertTrue(newQty.contains(prop.getProperty("Qty")));
    }

    public void amendPriority() {
        WebDriverWait wait = new WebDriverWait(webDriver, 3);
        wait.until(ExpectedConditions.visibilityOf(orderPrioritySelect));

        Select orderPriority = new Select(orderPrioritySelect);

        //Verify Dropdown does not support multiple selection
        Assert.assertFalse(orderPriority.isMultiple());
        //Verify Dropdown has three options for selection
        Assert.assertEquals(3, orderPriority.getOptions().size());

        //We will verify Dropdown has expected values as listed in a array
        List<String> exp_options = Arrays.asList(new String[]{"High", "Medium", "Low"});
        System.out.println("The existing order priority are: " + exp_options);
        //select from List
        orderPriority.selectByVisibleText("High");

    }
public void assertPriority() {

        saveChanges.click();

    Assert.assertTrue(orderPrioritySelect.getText().contains("High"));
}
}


















