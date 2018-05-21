package pages;

import Base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class JobsPage extends BaseUtil {

    public JobsPage(WebDriver webdriver) {

        this.webDriver = webdriver;
        PageFactory.initElements ( webDriver, this );
    }

/*
Selectors for the Jobs Admin tab
 */

    @FindBy(css = "[id='menu_admin_viewAdminModule']")
    public WebElement adminTab;


    @FindBy (id = "menu_admin_Job")
    public WebElement JobMenuSelector;

    @FindBy(id = "menu_admin_viewJobTitleList")
    public WebElement JobTItleListSelector;

    @FindBy(id = "menu_admin_viewPayGrades")
    public WebElement ViewPayGradesSelector;

    @FindBy (id = "menu_admin_employmentStatus")
    public  WebElement employmentStatusSelector;

    @FindBy (id = "menu_admin_jobCategory")
    public WebElement jobCategorySelector;

    @FindBy (id = "menu_admin_workShift")
    public  WebElement workShiftSelector;


    /*     Selectors for the Job Titles table   */

    public void adminTab () {

        Actions action = new Actions (webDriver);

     action.moveToElement (adminTab).build ().perform ();
     action.moveToElement (JobMenuSelector).build ().perform();
     action.moveToElement(JobTItleListSelector).build().perform();
        adminTab.click ();
        JobMenuSelector.click ();
        JobTItleListSelector.click();


    }

    public void jobTitles() {
/* Search on the table  */

        WebElement test = webDriver.findElement(By.cssSelector("[name='frmList_ohrmListComponent']"));

        for(int i = 0; i <test .findElements(By.cssSelector("[class='left']")).size();i++)

            if (test.findElements(By.cssSelector("[class='left']")).get(i).getText().contains("test"))
            {

               test.findElements(By.cssSelector("[class='left']")).get(i).click();
               break;
            }



    }
}
