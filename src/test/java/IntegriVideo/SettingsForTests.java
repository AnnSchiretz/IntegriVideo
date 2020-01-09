package IntegriVideo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class SettingsForTests {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://dev.integrivideo.com/demo/chat/new");
        wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("integri-component-chat")));
    }

    void sendMessage(String message, String checkLocator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea"))).clear();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea"))).sendKeys(message);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Send message']"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(checkLocator)));
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
