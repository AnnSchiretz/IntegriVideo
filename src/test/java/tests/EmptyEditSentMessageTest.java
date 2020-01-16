package tests;

import org.testng.annotations.Test;
import pages.IntegriVideoChat;

public class EmptyEditSentMessageTest extends SettingsForTests {
    IntegriVideoChat chat;
    @Test
    public void sentEmptyEditMessage() {
        String message = "Hello, again";
        chat = new IntegriVideoChat(driver);
        chat.sendMessage(message);
        chat.messageShouldContainText(message, 1);
        chat.makeMessageEmptyAndSend();
    }
}
