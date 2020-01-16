package tests;

import org.testng.annotations.Test;
import pages.IntegriVideoChat;

public class SendMessageWithLinkTest extends SettingsForTests {
    IntegriVideoChat chat;
    @Test
    public void sendMessageWithLink() {
        String message = "Hello! https://habr.com/ru/";
        String locator = "//div[@id='TMpanel']";
        chat = new IntegriVideoChat(driver);
        chat.sendMessage(message);
        chat.messageShouldContainText(message, 1);
        chat.followingTheLinkInMessage();
        chat.moveToAnotherTabs(1, locator);
    }
}
