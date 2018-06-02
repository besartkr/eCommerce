package pages;

import Base.BaseUtil;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

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

    /*     add Job title */
    @FindBy(name = "jobTitle[jobTitle]")
    public WebElement newJobTitle;

    @FindBy(name = "jobTitle[jobDescription]")
    public WebElement newJobDescription;

    @FindBy(name = "jobTitle[jobSpec]")
    public WebElement newJobUploadSpecs;

    @FindBy(id = "jobTitle_note")
    public WebElement newJobNotes;

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
        // To locate table
        WebElement baseTable = resultsTable;

        //    take all of the element under Column "State" inside list

        List<WebElement> columVal = baseTable.findElements(By.tagName("tr"));

        System.out.println("Total Number of Rows = " + columVal.size());

        // now for matching one of the content and then performing some action please start a for loop

        // String CEO = "CEO exists in the database";
        for (int i = 0; i < columVal.size(); i++) {
            System.out.println("Existing jobs in the list : " + columVal.get(i).getText());
            // match the content here in the if loop

            if (columVal.get(i).getTagName().equals("CEO")) {

                // perform action
                columVal.get(i).click();

            }
        }
    }

    public void addNewJob() {
        addNewJob.click();

    }

    public void enterNewJobDetails () throws IOException, InterruptedException {


        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\besart.kryeziu\\Desktop\\myFirst\\src\\test\\java\\pages\\datadriven.properties");
        prop.load(file);

        newJobTitle.sendKeys(prop.getProperty("JobTitle"));
        newJobDescription.sendKeys(prop.getProperty("JobDescription"));

        WebElement file_input = webDriver.findElement(By.name("jobTitle[jobSpec]"));
        Thread.sleep(2000);
        file_input.click();
        file_input.sendKeys("CVBesart.pdf");
        file_input.sendKeys(Keys.ENTER);



        }

    }


