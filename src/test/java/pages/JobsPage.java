package pages;

import Base.BaseUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobsPage extends BaseUtil {

    public JobsPage(WebDriver webdriver) {

        this.webDriver = webdriver;
        PageFactory.initElements ( webDriver, this );
    }



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
}

