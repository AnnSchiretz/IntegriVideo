package IntegriVideo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DeleteMessageTest extends SettingsForTests {
    @Test
    public void sendMessage() {
        String message = "Hello";
        String checkLocator = "//div[@class='integri-chat-message ']/div";
        sendingMessage(message, checkLocator);
        deleteMessage();
    }

    private void deleteMessage() {
        WebElement sentMessage = driver.findElement(By.xpath("//div[contains(text(), 'Hello')]/../following-sibling::div/span"));
        sentMessage.click();
        wait.until(ExpectedConditions.visibilityOf(sentMessage));
        driver.findElement(By.cssSelector(".iv-icon-trash2")).click();
        Alert alert = driver.switchTo().alert();
        String alertResult = alert.getText();
        assertEquals(alertResult, "Are you sure to delete message?", "Неверное сообщение в аллерте");
        alert.accept();
        driver.navigate().refresh();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".integri-chat-message-own")));
    }
}
