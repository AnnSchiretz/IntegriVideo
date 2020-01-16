package tests;

import org.testng.annotations.Test;
import pages.IntegriVideoChat;
import pages.IntegriVideoSettings;

public class EditUserNameTest extends SettingsForTests {
    IntegriVideoChat chat;
    IntegriVideoSettings settings;
    @Test
    public void editName() {
        String newName = "LionGuest";
        chat = new IntegriVideoChat(driver);
        settings = new IntegriVideoSettings(driver);

        chat.goToSettingsModal();
        settings.inputUserInFormAndSave(newName);
        driver.navigate().refresh();
        chat.validationUserName(newName);
    }
}
