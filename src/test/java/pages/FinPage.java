package pages;

import Base.BaseUtil;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class FinPage extends BaseUtil {

    public FinPage(WebDriver webdriver) {

        this.webDriver = webdriver;
        PageFactory.initElements(webDriver, this);
    }

/*
Selectors for the Jobs Admin tab
 */

    @FindBy(name = "UserID")
    public WebElement userID;

    @FindBy(id = "Submit")
    public WebElement loginOK;

    @FindBy(id = "TheForm")
    public WebElement assertLogin;

    /*Menu Tab selectors */

    @FindBy(css = "[class='TM'] [href='/web/menu.htm']")
    public WebElement MenuTab;

    @FindBy(css = "[class='banmenuinner'] [href='/web/ServiceDirectoryMaintenance.htm']")
    public WebElement MenuTabServicDirectory;

    @FindBy(xpath = "//*[@id=\"xpaint\"]/div[2]/div/div[2]/a")
    public WebElement NewServiceCategory;

    @FindBy(xpath = "<span style=\"padding-right:100px; display:inline-block; position:relative; padding:10px;\">New Service Category</span>")
    public WebElement NewServiceCategoryBanner;

    @FindBy(id = "dv_Description")
    public WebElement newDescription;

    @FindBy(name = "dv_Application__LCS")
    public WebElement newApplicationChildren;

    @FindBy(name = "dv_Application__EYES")
    public WebElement newApplicationEYES;

    @FindBy(id = "dv_Brokerage_ext")
    public WebElement BrokerageSelector;


    /*Brokerage List */
    @FindBy(css = "[origva='Mandatory']")
    public WebElement Mandatory;

    @FindBy(css = "[origva='Never']")
    public WebElement Never;


    @FindBy(css = "[origva='Optional']")
    public WebElement Optional;


    /* Provision Detail View */
    @FindBy(id = "dv_ProvisionDetailView_ext")
    public WebElement ProvisionDetailviewSelector;

    @FindBy(css = "[value='DAY']")
    public WebElement ServiceDay;

    @FindBy(css = "[value='RANGE']")
    public WebElement ServiceTimeRange;

    @FindBy(css = "[value='VISIT']")
    public WebElement ServiceVisit;

    @FindBy(css = "[value='WEEK']")
    public WebElement ServicWeek;


    /*Personal Budget */
    @FindBy(css = "[id='dv_PersonalBudget__true']")
    public WebElement PersonalBudgetTrue;

    @FindBy(css = "[id='dv_PersonalBudget__false']")
    public WebElement PersonalBudgetFalse;


    /*Variations Allowed */
    @FindBy(css = "[id='dv_PlannedVariationsAllowed__true']")
    public WebElement VariationsAllowedTrue;

    @FindBy(css = "[id='dv_PlannedVariationsAllowed__false']")
    public WebElement VariationsAllowedFalse;


    /* Unable to create record message */
    @FindBy(css = "[class='IPAD']")
    public WebElement unableToCreateRecord;

    @FindBy(css = "#xpaint > div.xpaintbody > div > div:nth-child(2) > div.BANNERACTION > a:nth-child(1)")
    public WebElement CreateRecord;


    /*
    Serivce Directory - Filter selectors
     */

    @FindBy (name = "Filter")
    public WebElement FilterSelector;

    public void enterLoginDetails() throws IOException {

        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\besart.kryeziu\\Desktop\\myFirst\\src\\test\\java\\pages\\datadriven.properties");
        prop.load(file);
        ;

        userID.sendKeys(prop.getProperty("finUserName"));

    }

    public void login() {

        loginOK.click();
    }

    public void assertLogin() {
        Assert.assertTrue(assertLogin.isDisplayed());

    }


    public void navigatetoServiceDirectory() throws InterruptedException {

        Actions action = new Actions(webDriver);
        action.moveToElement(MenuTab).perform();
        Thread.sleep(2000);
        action.click(MenuTabServicDirectory).perform();

    }

    public void serviceCategoryDetails() throws IOException, InterruptedException {

        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\besart.kryeziu\\Desktop\\myFirst\\src\\test\\java\\pages\\datadriven.properties");
        prop.load(file);
        ;

        //NewServiceCategory.click();
        Thread.sleep(1000);

        newDescription.sendKeys(prop.getProperty("newServiceCategory"));

    }

    /*Select application */
    public void selectApplication() throws InterruptedException {
        Thread.sleep(1000);
        if (!newApplicationChildren.isSelected()) {
            newApplicationChildren.click();
            Assert.assertTrue(newApplicationChildren.isSelected());
        }
        if (!newApplicationEYES.isSelected()) {
            newApplicationEYES.click();
            Assert.assertTrue(newApplicationEYES.isSelected());
        }


        /* Select Brokerage */
    }

    public boolean brokerageList() throws InterruptedException {
        Thread.sleep(2000);

        BrokerageSelector.click();


        if (Mandatory.isDisplayed()) {

            return true;
        }

        if (Never.isDisplayed()) {

            return true;

        }

        if (Optional.isDisplayed()) {

            return true;
        } else {

            return false;

        }
    }

    public void selectBrokerage() {
        Optional.click();
    }

    /* Select provisionDetailView */
    public boolean provisionDetailView() throws InterruptedException {

        Thread.sleep(2000);

        ProvisionDetailviewSelector.click();

        if (ServiceDay.isDisplayed()) {

            return true;

        }

        if (ServiceTimeRange.isDisplayed()) {

            return true;

        }

        if (ServiceVisit.isDisplayed()) {

            return true;

        }
        if (ServicWeek.isDisplayed()) {

            return true;

        } else {
            return false;

        }

    }

    public void selectProvisionDetailView() throws InterruptedException

    {
        Thread.sleep(1000);
        ServicWeek.click();
    }

    /* Select pesonalBudget */

    public void pesonalBudget() throws InterruptedException {
        Thread.sleep(1000);

        if (!PersonalBudgetTrue.isSelected())
            PersonalBudgetTrue.click();

        Assert.assertTrue(PersonalBudgetTrue.isSelected());


    }

    /* Select variationsAllowed */

    public void variationsAllowed() throws InterruptedException {
        Thread.sleep(1000);


        if (!VariationsAllowedFalse.isSelected())
            VariationsAllowedFalse.click();

        Assert.assertTrue(VariationsAllowedFalse.isSelected());

    }

    public void create () {

    }

        }









