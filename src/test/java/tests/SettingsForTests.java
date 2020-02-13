package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import steps.*;
import utils.CapabilitiesGenerator;

public class SettingsForTests {
    WebDriver driver;
    WebDriverWait wait;
    BillingSteps billingSteps;
    IntegriVideoChatSteps chatSteps;
    IntegriVideoSettingsSteps settingsSteps;
    IntegriVideoUploadSteps uploadSteps;
    LogInSteps logInSteps;
    ProjectSteps projectSteps;

    @BeforeMethod
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".integri-chat-bottom-text")));
        billingSteps = new BillingSteps(driver);
        chatSteps = new IntegriVideoChatSteps(driver);
        settingsSteps = new IntegriVideoSettingsSteps(driver);
        uploadSteps = new IntegriVideoUploadSteps(driver);
        logInSteps = new LogInSteps(driver);
        projectSteps = new ProjectSteps(driver);
    }
    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
