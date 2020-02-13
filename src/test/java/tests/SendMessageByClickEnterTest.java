package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class SendMessageByClickEnterTest extends SettingsForTests {
    @Test(description = "Send message ")
    @Description("Send message by enter")
    public void sendMessage() {
        String message = "Hello!";
        chatSteps.sendMessageByEnterAndValidationText(message, 1);
    }
}
