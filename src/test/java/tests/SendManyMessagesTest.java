package tests;

import org.testng.annotations.Test;
import pages.IntegriVideoChat;

import java.util.concurrent.TimeUnit;

public class SendManyMessagesTest extends SettingsForTests {
    IntegriVideoChat chat;
    @Test
    public void sendManyMessage() {
        String message = "Hello";
        chat = new IntegriVideoChat(driver);
        int count = chat.getCountMessage();
        for (int i = 0; i <= 9; i++) {
            chat.setMessage(message);
            chat.clickSendMessage();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            chat.messageShouldContainText(message,count);
            count++;
        }
        chat.setMessage(message);
        chat.clickSendMessage();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        chat.skipTrialVersion();
    }
}
