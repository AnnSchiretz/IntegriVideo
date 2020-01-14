package IntegriVideo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SendManyMessagesTest extends SettingsForTests {
    @Test
    public void sendManyMessage() {
        String message = "Hello";

        int count = driver.findElements(By.cssSelector(".integri-chat-messages")).size();
        for (int i = 0; i <= 12; i++) {
            String checkLocator = "//div[@class=\"integri-chat-messages\"]//div['" + count + "']//div[@class=\"integri-chat-message-text\"]";
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea"))).sendKeys(message);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Send message']"))).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(checkLocator)));
            count++;
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'This is trial version')]")));
    }
}
