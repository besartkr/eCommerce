package pages;

import Base.BaseUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(css = "[class='largeTextBox'] [class='valid']")
    public WebElement isuploadValidated;

    @FindBy(id = "btnSave")
    public WebElement saveNewJob;


    @FindBy(xpath = "//*[@id=\"frmSavejobTitle\"]/fieldset/ol/li[1]/span")
    public WebElement validationError;


    @FindBy(css = "[class='message success fadable']")
    public WebElement successMessage;

    @FindBy(css = "[class='editButton']")
    public WebElement editButton;

    public void adminTab() {

        Actions action = new Actions(webDriver);

        action.moveToElement(adminTab).build().perform();
        action.moveToElement(JobMenuSelector).build().perform();
        action.moveToElement(JobTItleListSelector).build().perform();
        adminTab.click();
        JobMenuSelector.click();
        JobTItleListSelector.click();


    }

    public void existingJobTitles() throws InterruptedException {
        WebElement table = webDriver.findElement(By.id("resultTable"));
        List<WebElement> buttons = table.findElements(By.tagName("a"));

        for (WebElement b : buttons) {
            if (b.getText().equals("CEO")) {
                b.click();
                break;
            }
        }
    }

    public void addNewJob() {
        addNewJob.click();

    }

    public void enterNewJobDetails() throws IOException, InterruptedException {


        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\besart.kryeziu\\Desktop\\myFirst\\src\\test\\java\\pages\\datadriven.properties");
        //  FileInputStream file = new FileInputStream("C:\\Users\\besart\\Desktop\\firstCommit\\src\\test\\java\\pages\\datadriven.properties");
        prop.load(file);
        ;


        newJobTitle.sendKeys(prop.getProperty("JobTitle"));
        Thread.sleep(2000);


        if (!validationError.equals(null)) {

            boolean expectedData = webDriver.findElement(By.xpath("//*[@id=\"frmSavejobTitle\"]/fieldset/ol/li[1]/span")).isDisplayed();

            if (expectedData) {
                newJobTitle.click();
                newJobTitle.clear();
                newJobTitle.sendKeys(prop.getProperty("2ndJobTitle"));
            }
            if (expectedData) {
                newJobTitle.click();
                newJobTitle.clear();
                newJobTitle.sendKeys(prop.getProperty("3rdJobTitle"));

            }

            if (newJobDescription.getText().isEmpty()) {
                newJobDescription.sendKeys(prop.getProperty("JobDescription"));

            }


            Thread.sleep(1000);

            // if (newJobUploadSpecs.getText().isEmpty()) {
            //    newJobUploadSpecs.sendKeys(prop.getProperty("JobUploadSpecs"));
            //   }

            if (newJobNotes.getText().isEmpty()) {
                newJobNotes.sendKeys(prop.getProperty("JobNotes"));
            }
            saveNewJob.click();
        }

    }

    public void assertNewJobAdded() {


        Assert.assertTrue(successMessage.isDisplayed());

    }

    public void editJobTitle() throws InterruptedException, IOException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\besart.kryeziu\\Desktop\\myFirst\\src\\test\\java\\pages\\datadriven.properties");
        //  FileInputStream file = new FileInputStream("C:\\Users\\besart\\Desktop\\firstCommit\\src\\test\\java\\pages\\datadriven.properties");
        prop.load(file);
        ;

        Thread.sleep(2000);

        if (editButton.isDisplayed()) {
            editButton.click();

        }

        if (newJobTitle.isDisplayed()) {
            newJobTitle.sendKeys(prop.getProperty("3rdJobTitle"));

        }

        if (newJobDescription.isDisplayed()) {
            newJobDescription.sendKeys(prop.getProperty("JobDescription"));

        }
        if (newJobNotes.isDisplayed()) {
            newJobNotes.sendKeys(prop.getProperty("JobNotes"));

        }
        saveNewJob.click();

    }

    public boolean confirmChanges() {
        if (successMessage.isDisplayed()) {

            return true;

        } else {
            return false;
        }
    }

    public void selectAndDeleteJobTitle() {

    }
}


