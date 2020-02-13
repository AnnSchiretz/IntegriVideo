package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class SendManyMessagesTest extends SettingsForTests {
    @Test(description = "Send many message")
    @Description("Check visibility modal window this message about trail version")
    public void sendManyMessage() {
        String message = "Hello";
        int count = chatSteps.getCountMessage();
        for (int i = 0; i <= 9; i++) {
            chatSteps.sendMessageAndEqualsText(message,count);
            count++;
        }
        chatSteps.sendMessageAndSkipTrialVersion(message);
    }
}
