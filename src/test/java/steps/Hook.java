package steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hook extends BaseUtil {


    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\besart.kryeziu\\Desktop\\myFirst\\src\\test\\java\\pages\\datadriven.properties");
        //FileInputStream fis = new FileInputStream("C:\\Users\\besart\\Desktop\\firstCommit\\src\\test\\java\\pages\\datadriven.properties");
        prop.load(fis);

        if (prop.getProperty("browser").equals("chrome")) {
           System.setProperty("webdriver.chrome.driver", "C:\\Users\\besart.kryeziu\\Downloads\\automation\\chromedriver_win32\\chromedriver.exe");

             //System.setProperty("webdriver.chrome.driver", "C:\\Users\\besart\\Downloads\\automation\\chromedriver_win32\\chromedriver.exe");
            base.webDriver = new ChromeDriver();

        } else if
                (prop.getProperty("browser").equals("firefox")) {
            System.setProperty("webdriver.firefox.marionette", "C:\\Users\\besart\\Downloads\\automation\\geckodriver-v0.20.1-win64\\geckodriver.exe");
            base.webDriver = new FirefoxDriver();

        } else {
            if (prop.getProperty("browser").equals("internetExplorer")) {
                System.setProperty("webdriver.ie.driver", "C:\\Users\\besart.kryeziu\\Downloads\\automation\\IEDriverServer.exe");
                base.webDriver = new InternetExplorerDriver();
            }
        }

    }

    @Given("^I navigate to the home page$")
    public void iNavigateToTheHomePage() throws Throwable {

        base.webDriver.navigate().to("http://automationpractice.com/index.php");

    }

    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take screenshot logic goes here
            System.out.println(scenario.getName());
        }

    }

}
