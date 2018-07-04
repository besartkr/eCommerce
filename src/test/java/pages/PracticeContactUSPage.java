package pages;

import Base.BaseUtil;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.util.Properties;


public class PracticeContactUSPage extends BaseUtil {

    public PracticeContactUSPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    @FindBy(id = "contact-link")
    WebElement contactLink;

    @FindBy(id = "id_contact")
    WebElement subjecSelector;

    @FindBy(id = "email")
    WebElement emailAddress;

    @FindBy(name = "id_order")
    WebElement orderRef;

    @FindBy(name = "message")
    WebElement enterMessage;

    @FindBy(name = "submitMessage")
    WebElement sendMessage;


    @FindBy(css = "[class='alert alert-success']")
    WebElement successfullySent;

    public void contactUs() {
        contactLink.click();
        Assert.assertTrue(webDriver.getTitle().contains("Contact us - My Store"));


    }
/*
  Actions action = new Actions(webDriver);
        action.moveToElement(MenuTab).perform();
        Thread.sleep(2000);
        action.click(MenuTabServicDirectory).perform();
 */
    public void messageDetails() throws Exception {

        Properties prop = new Properties();

        FileInputStream file = new FileInputStream("C:\\Users\\besart.kryeziu\\Desktop\\myFirst\\src\\test\\java\\pages\\datadriven.properties");
        //  FileInputStream file = new FileInputStream("C:\\Users\\besart\\Desktop\\firstCommit\\src\\test\\java\\pages\\datadriven.properties");
        prop.load(file);

        ;


        Select subject = new Select(subjecSelector);
        subject.selectByVisibleText("Customer service");

        if (emailAddress.getText().isEmpty())

            emailAddress.sendKeys(prop.getProperty("email"));

        if (orderRef.getText().isEmpty())
            orderRef.sendKeys(prop.getProperty("orderID"));

        if (enterMessage.getText().isEmpty()) {
            enterMessage.sendKeys(prop.getProperty("message"));
        }

    }

    public void sendMessage() throws Exception {

        sendMessage.click();

        if (webDriver.findElements(By.cssSelector("[class='alert alert-danger']")).size() > 0) {

            throw new Exception("Error exists in the page - Mandatory details not completed");

        } else {
            Assert.assertTrue(successfullySent.isDisplayed());

            String text = successfullySent.getText();
            System.out.println(text);
        }

    }
}















