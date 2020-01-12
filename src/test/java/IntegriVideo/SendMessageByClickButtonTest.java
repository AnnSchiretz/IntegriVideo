package IntegriVideo;

import org.testng.annotations.Test;

public class SendMessageByClickButtonTest extends SettingsForTests {
    @Test
    public void sendMessageByButton() {
        String message = "Hello!";
        String checkLocator = "//div[@class='integri-chat-message ']/div";
        sendingMessage(message, checkLocator);
    }
}
