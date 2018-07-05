package pages;

import Base.BaseUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.WeakHashMap;


public class PracticePageWishPage extends BaseUtil {

    public PracticePageWishPage(WebDriver webDriver) {
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


/*
  Actions action = new Actions(webDriver);
        action.moveToElement(MenuTab).perform();
        Thread.sleep(2000);
        action.click(MenuTabServicDirectory).perform();
 */

    public WebElement wishListPage() {
        if (MyWishList.isDisplayed()) {
            MyWishList.click();
        } else if (MyAccount.isDisplayed()) {
            MyAccount.click();
            MyWishList.click();

        }


        Assert.assertEquals("My Store", webDriver.getTitle());
        return MyWishList;

    }

    public void wishListTable() throws InterruptedException {

        Boolean isWishListPresent = webDriver.findElements(By.id("block-history")).size() != 0;
        if (isWishListPresent == true) {
            System.out.println("Items in WishList table");
            Thread.sleep(1000);


        } else {
            productSeletor.click();
            Thread.sleep(1000);
            wishListButton.click();
            Thread.sleep(1000);
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

    public void orderDetail() throws InterruptedException {
        Thread.sleep(1000);
        if (vieworderDetailLink.isDisplayed()) {
            vieworderDetailLink.click();
            Assert.assertTrue(orderDetailTable.isDisplayed());
        }
        String Qty = orderQty.getText();
        int n = Integer.parseInt(Qty);

        System.out.println("The existing qty is: " + n);

        Thread.sleep(1000);
        orderQtyDetailTable.click();
        String QtyDetail = orderQtyDetailTable.getText();
        int qty = Integer.parseInt(QtyDetail);
        if (qty == 2) ;
        orderQtyDetailTable.sendKeys("10");
    }
}



















