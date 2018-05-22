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
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.NoSuchElementException;

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


    public void adminTab() {

        Actions action = new Actions(webDriver);

        action.moveToElement(adminTab).build().perform();
        action.moveToElement(JobMenuSelector).build().perform();
        action.moveToElement(JobTItleListSelector).build().perform();
        adminTab.click();
        JobMenuSelector.click();
        JobTItleListSelector.click();


    }

    public void jobTitles() {
        /* Search on the table

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
        try {
            for (int i = 0; i < 5; i++) {
                try {
                    if (!webDriver.findElements(By.xpath("/html/body/div[@class='container']/table[@class='table table-striped'][2]/tbody[@id='bought']/tr[@id=" + i + "]/th[4]/button")).isEmpty()) {
                        try {
                            webDriver.findElement(By.xpath("/html/body/div[@class='container']/table[@class='table table-striped'][2]/tbody[@id='bought']/tr[@id=" + i + "]/th[4]/button")).click();
                        } catch (java.util.NoSuchElementException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            System.out.println("no products to sell ");
                        } catch (NoSuchElementException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}