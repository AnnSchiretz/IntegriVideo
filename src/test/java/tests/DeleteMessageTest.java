package tests;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import pages.IntegriVideoChat;

import static org.testng.Assert.assertEquals;

public class DeleteMessageTest extends SettingsForTests {
    IntegriVideoChat chat;
    @Test
    public void sendMessage() {
        String message = "Hello";
        chat = new IntegriVideoChat(driver);
        chat.sendMessage(message);
        chat.deleteMessage(1);
        moveAndAcceptAlert();
    }

    private void moveAndAcceptAlert() {
        Alert alert = driver.switchTo().alert();
        String alertResult = alert.getText();
        assertEquals(alertResult, "Are you sure to delete message?", "Неверное сообщение в аллерте");
        alert.accept();
        driver.navigate().refresh();
    }
}
