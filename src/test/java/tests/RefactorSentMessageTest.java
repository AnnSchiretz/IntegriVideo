package tests;

import org.testng.annotations.Test;
import pages.IntegriVideoChat;

public class RefactorSentMessageTest extends SettingsForTests {
    IntegriVideoChat chat;
    @Test
    public void sendAndRefactorMessage() {
        String message = "Hello! How are you?";
        String textEdit = "Are you OK?";
        chat = new IntegriVideoChat(driver);
        chat.sendMessage(message);
        chat.messageShouldContainText(message, 1);
        chat.clickEditMessage(textEdit, 1);
        chat.messageShouldContainText(textEdit, 1);
    }
}
