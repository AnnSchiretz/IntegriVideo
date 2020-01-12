package IntegriVideo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SendMessageByClickEnterTest extends SettingsForTests {

    @Test
    public void sendMessage() {
        String message = "Hello!";
        String checkMessage = "//div[@class='integri-chat-message ']/div";
        WebElement messageInput = driver.findElement(By.xpath("//textarea"));
        messageInput.sendKeys(message);
        messageInput.sendKeys(Keys.ENTER);
        String messageInChat = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(checkMessage))).getText();
        assertEquals(messageInChat, message, "Не совпал текст сообщения с ожидаемым");
    }
}
