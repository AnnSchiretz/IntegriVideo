package IntegriVideo;

import org.testng.annotations.Test;

public class SendMessageWithLinkTest extends SettingsForTests {
    @Test
    public void sendMessageWithLink() {
        String message = "Hello! https://habr.com/ru/";
        String checkLocator = "//div[contains(text(), 'Hello!')]/a";
        sendMessage(message, checkLocator);
    }
}
