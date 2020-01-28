package tests;

import org.testng.annotations.Test;
import pages.IntegriVideoChat;

public class SendMessageByClickButtonTest extends SettingsForTests {
    IntegriVideoChat chat;
    @Test
    public void sendMessageByButton() {
        String message = "Hello!";
        chat = new IntegriVideoChat(driver);
        chat.sendMessage(message);
        chat.messageShouldContainText(message, 1);
    }
}
