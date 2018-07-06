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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


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

    @FindBy(css = "[class='btn btn-default button button-small']")
    WebElement saveChanges;


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

    public void orderDetail() throws IOException, InterruptedException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\besart.kryeziu\\Desktop\\myFirst\\src\\test\\java\\pages\\datadriven.properties");
        //  FileInputStream file = new FileInputStream("C:\\Users\\besart\\Desktop\\firstCommit\\src\\test\\java\\pages\\datadriven.properties");
        prop.load(file);

        WebDriverWait wait = new WebDriverWait(webDriver, 3);

        if (vieworderDetailLink.isDisplayed()) {
            vieworderDetailLink.click();
            Assert.assertTrue(orderDetailTable.isDisplayed());
        }

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

            saveChanges.click();
        } else {
            wait.until(ExpectedConditions.visibilityOf(orderQtyDetailTable));

            orderQtyDetailTable.sendKeys(prop.getProperty("Qty"));

            saveChanges.click();

        }


    }

    public void updatedQty() {
        Assert.assertEquals(orderQty, orderQtyDetailTable);
    }
}



















