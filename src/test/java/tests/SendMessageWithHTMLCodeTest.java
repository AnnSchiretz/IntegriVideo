package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class SendMessageWithHTMLCodeTest extends SettingsForTests {
    @Test(description = "Send message with html code")
    @Description("validation message with html code")
    public void sendInvalidMessage() {
        String sendMessage = "<html><body><p>test</p></body></html>";
        String messageText = "test";
        chatSteps.sendMessage(sendMessage)
                .validationMessage(messageText, 1);
    }
}
