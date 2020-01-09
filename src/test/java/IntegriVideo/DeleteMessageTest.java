package IntegriVideo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DeleteMessageTest extends SettingsForTests {
    @Test
    public void sendMessageAndDelete() {
        String message = "Hello";
        String checkLocator = "//div[contains(text(), 'Hello')]";
        sendMessage(message, checkLocator);
        driver.findElement(By.xpath("//div[contains(text(), 'Hello')]/../following-sibling::div/span")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(), 'Hello')]/../following-sibling::div/span"))));
        driver.findElement(By.cssSelector(".iv-icon-trash2")).click();
        Alert alert = driver.switchTo().alert();
        String alertResult = alert.getText();
        assertEquals(alertResult, "Are you sure to delete message?", "Неверное сообщение в аллерте");
        alert.accept();
        driver.navigate().refresh();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".integri-chat-message-own")));
    }
}
