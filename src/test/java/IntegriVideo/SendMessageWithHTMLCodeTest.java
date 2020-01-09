package IntegriVideo;

import org.testng.annotations.Test;

public class SendMessageWithHTMLCodeTest extends SettingsForTests {
    @Test
    public void sendInvalidMessage() {
        String sendMessage = "<html><body><p>test</p></body></html>";
        String checkLocator = "//p";
        sendMessage(sendMessage, checkLocator);
    }
}
