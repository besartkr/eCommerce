package pages;

import Base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AdminPage extends BaseUtil {

    public AdminPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "systemUser_userType")
    public WebElement UserRole;

    @FindBy(css = "[id='menu_admin_viewAdminModule']")
    public WebElement adminTab;

    @FindBy(id = "btnAdd")
    public WebElement addNewAdmin;

    @FindBy(id = "systemUser_employeeName_empName")
    public WebElement EmployeeName;

    @FindBy(id = "systemUser_userName")
    public WebElement EmployeeUsername;

    @FindBy(id = "systemUser_password")
    public WebElement Password;

    @FindBy(id = "systemUser_confirmPassword")
    public WebElement ConfirmPassword;

    @FindBy(css = "[class='addbutton']")
    public WebElement FormSave;

    @FindBy(css = "[class='message success fadable']")
    public WebElement successMessage;

    @FindBy(id = "searchSystemUser_userName")
    public WebElement SearchUser;

    @FindBy(id = "searchSystemUser_employeeName_empName")
    public WebElement Employeename;

    @FindBy(id = "searchBtn")
    public WebElement doSearch;

    /* click my name on search Results */
    @FindBy(css = "[href='saveSystemUser?userId=11']")
    public WebElement myNameSearched;

    /* edit Employer name */
    @FindBy(name = "systemUser[userType]")
    public WebElement ChangeEmployeName;

    /* Enable to edit details*/
    @FindBy(name = "btnSave")
    public WebElement editDetails;

    @FindBy(name = "systemUser[userType]")
    public WebElement userRorle;

    public void userrole() {

        Select dropdown = new Select(UserRole);
        dropdown.selectByValue("1");

    }

    /* link for admin tab */
    public void adminTab() {
        adminTab.click();
    }

    /*save Button for new users*/
    public void saveDetails() {
        FormSave.click();
    }


    /*Confirm details entered are accepted */
    public void successfullySaved() throws InterruptedException {

        Thread.sleep(1000);
        successMessage.getText().contains("Successfully Saved");
    }

    /* Add link for new Admin user */
    public void setAddNewAdmin() {
        addNewAdmin.click();
    }

    public void searchExistingUser() {


    }

    /*Pull users from the feature file */
    public void Management(String employeeName, String Username, String password, String confirmpass) {
        EmployeeName.sendKeys(employeeName);
        EmployeeUsername.sendKeys(Username);
        Password.sendKeys(password);
        ConfirmPassword.sendKeys(confirmpass);

    }

    /*Delete admin users */
    public void deleteAdminusers(String ADDUserName, String Username) {
        SearchUser.sendKeys(ADDUserName);
        Employeename.sendKeys(Username);

    }

    public void selecttoSearch() {
        doSearch.click();
        myNameSearched.click();

    }

    public boolean enabletToEditDetails() {

        Boolean dropdownPresent = ChangeEmployeName.isEnabled();

        if (dropdownPresent == true) {
            return true;
        } else {
            editDetails.click();

            return false;
        }
    }

    public void ChangeEmployeDetails() {

        Select userrole = new Select(userRorle);
        userrole.selectByValue("2");


        {

        }
    }

    public void saveButton() {
        editDetails.click();
    }

}
