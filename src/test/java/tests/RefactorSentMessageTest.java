package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class RefactorSentMessageTest extends SettingsForTests {
    @Test(description = "Edit send message in chat window")
    @Description("Check edit message option")
    public void sendAndRefactorMessage() {
        String message = "Hello! How are you?";
        String textEdit = "Are you OK?";
        chatSteps.sendMessageAndEqualsText(message, 1)
                .editMessageWithValidation(textEdit,1);
    }
}
