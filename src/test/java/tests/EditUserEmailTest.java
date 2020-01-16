package tests;

import org.testng.annotations.Test;
import pages.IntegriVideoChat;
import pages.IntegriVideoSettings;

public class EditUserEmailTest extends SettingsForTests {
    IntegriVideoChat chat;
    IntegriVideoSettings settings;
    @Test
    public void editEmail() {
        String newEmail = "123456@gmail.com";
        settings = new IntegriVideoSettings(driver);
        chat = new IntegriVideoChat(driver);
        chat.goToSettingsModal();
        settings.inputEmailInFormAndSave(newEmail);
        chat.goToSettingsModal();
        settings.validationEmail(newEmail);
    }
}
