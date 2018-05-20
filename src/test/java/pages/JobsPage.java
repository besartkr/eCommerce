package pages;

import Base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static java.lang.Thread.sleep;

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

        @FindBy(css = "[class='odd']")
        public WebElement olddField;

        @FindBy(css = "[class='even']")
        public List <WebElement> evenField;

        /*        Add Link         */
        @FindBy (name = "btnAdd")
        public WebElement addButton;

        @FindBy(name = "jobTitle[jobTitle]")
        public WebElement enterJobTitle;

        @FindBy(name = "jobTitle[jobDescription]")
        public WebElement enterJobDesc;

        @FindBy(name = "jobTitle[note]")
        public WebElement enterNotes;

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

    /* Grab the table */

      WebElement table = webDriver.findElement ( By.id ( "resultTable" ) );

      /* Now get all the TR elements from the table */
      List <WebElement> allRows = table.findElements ( By.tagName ( "tr" ) );

      /* And iterate over them, getting the cells */
      for (WebElement row : allRows) {
          List <WebElement> cells = row.findElements ( By.partialLinkText ( "CEO" ) );

          /* Print the contents of each cell */
          for (WebElement cell : cells) {
              System.out.println ( cell.getText () );
              cell.click ();
          }

      }
  }
            }


