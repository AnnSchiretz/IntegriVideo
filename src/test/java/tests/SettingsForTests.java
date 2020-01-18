package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class SettingsForTests {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".integri-chat-bottom-text")));
    }
//    @AfterMethod
//    public void afterTest() {
//        driver.quit();
//    }
}
