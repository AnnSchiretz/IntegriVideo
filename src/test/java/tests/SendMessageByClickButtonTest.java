package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class SendMessageByClickButtonTest extends SettingsForTests {
    @Test(description = "Send message ")
    @Description("Check text in send message")
    public void sendMessageByButton() {
        String message = "Hello!";
        chatSteps.sendMessageAndEqualsText(message, 1);
    }
}
