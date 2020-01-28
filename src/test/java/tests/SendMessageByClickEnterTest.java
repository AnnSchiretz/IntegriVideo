package tests;

import org.testng.annotations.Test;
import pages.IntegriVideoChat;

public class SendMessageByClickEnterTest extends SettingsForTests {
    IntegriVideoChat chat;
    @Test
    public void sendMessage() {
        String message = "Hello!";
        chat = new IntegriVideoChat(driver);
        chat.sendMessage(message);
        chat.sendMessageByEnter();
        chat.messageShouldContainText(message, 1);
    }
}
