package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class EmptyEditSentMessageTest extends SettingsForTests {
    @Test(description = "Send message in chat and edit it")
    @Description("try send empty message")
    public void sentEmptyEditMessage() {
        String message = "Hello, again";
        chatSteps.sendMessageAndEqualsText(message, 1)
                    .editMessageWithValidation("", 1)
                    .checkAlertMessage();
    }
}
