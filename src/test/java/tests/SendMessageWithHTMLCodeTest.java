package tests;

import org.testng.annotations.Test;
import pages.IntegriVideoChat;

public class SendMessageWithHTMLCodeTest extends SettingsForTests {
    IntegriVideoChat chat;
    @Test
    public void sendInvalidMessage() {
        String sendMessage = "<html><body><p>test</p></body></html>";
        String messageText = "test";
        chat = new IntegriVideoChat(driver);
        chat.sendMessage(sendMessage);
        chat.messageShouldContainText(messageText, 1);
    }
}
