package IntegriVideo;

import org.testng.annotations.Test;

public class SendMessageByClickButtonTest extends SettingsForTests {
    @Test
    public void sendMessageByButton() {
        String message = "Hello!";
        String checkLocator = "//div[contains(text(),'Hello!')]";
        sendMessage(message, checkLocator);
    }
}
