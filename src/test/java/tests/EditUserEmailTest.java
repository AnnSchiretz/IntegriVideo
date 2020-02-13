package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class EditUserEmailTest extends SettingsForTests {
    @Test(description = "Send message in chat and edit it")
    @Description("try send empty message")
    public void editEmail() {
        String newEmail = "123456@gmail.com";
        chatSteps.goToSettingsChat();
        settingsSteps.changeEmail(newEmail);
        chatSteps.goToSettingsChat();
        settingsSteps.validationNewEmail(newEmail);
    }
}
