package pages;

import Base.BaseUtil;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class JobsPage extends BaseUtil {

    public JobsPage(WebDriver webdriver) {

        this.webDriver = webdriver;
        PageFactory.initElements(webDriver, this);
    }

/*
Selectors for the Jobs Admin tab
 */

    @FindBy(css = "[id='menu_admin_viewAdminModule']")
    public WebElement adminTab;


    @FindBy(id = "menu_admin_Job")
    public WebElement JobMenuSelector;

    @FindBy(id = "menu_admin_viewJobTitleList")
    public WebElement JobTItleListSelector;

    @FindBy(id = "menu_admin_viewPayGrades")
    public WebElement ViewPayGradesSelector;

    @FindBy(id = "menu_admin_employmentStatus")
    public WebElement employmentStatusSelector;

    @FindBy(id = "menu_admin_jobCategory")
    public WebElement jobCategorySelector;

    @FindBy(id = "menu_admin_workShift")
    public WebElement workShiftSelector;


    /*     Selectors for the Job Titles table   */

    @FindBy(css = "[id='resultTable']")
    public WebElement resultsTable;

    @FindBy(id = "btnAdd")
    public WebElement addNewJob;

    public void adminTab() {

        Actions action = new Actions(webDriver);

        action.moveToElement(adminTab).build().perform();
        action.moveToElement(JobMenuSelector).build().perform();
        action.moveToElement(JobTItleListSelector).build().perform();
        adminTab.click();
        JobMenuSelector.click();
        JobTItleListSelector.click();


    }

    public void jobTitles() throws InterruptedException {
        /* Search on the table  */

        WebElement baseTable = resultsTable;
        List<WebElement> linksOnTheTable = baseTable.findElements(By.tagName("a"));
        for (WebElement selectLink : linksOnTheTable) {
            Thread.sleep(2000);

            if (selectLink.getText().equals("CEO")) {
                selectLink.click();
                break;
            }

        }
    }
}
/*
        WebElement baseTable = resultsTable;
        List<WebElement> links = baseTable.findElements(By.tagName("a"));
        links.size();


        for (int i = 1; i <= links.size(); i = i + 1)

        {
            System.out.println(links.get(i).getText());

        }
    }
 }
*/