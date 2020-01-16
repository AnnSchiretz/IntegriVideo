package tests;

import org.testng.annotations.Test;
import pages.IntegriVideoChat;
import pages.IntegriVideoSettings;

public class UploadNewUserPhotoTest extends SettingsForTests {
    IntegriVideoChat chat;
    IntegriVideoSettings settings;
    @Test
    public void loadPhoto() {
        String urlPhoto = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQD-QtTfaj9n5-keZXFCUxOoull1z03cNe83tCQAgAWSpTntPy6&s";
        chat = new IntegriVideoChat(driver);
        settings = new IntegriVideoSettings(driver);
        chat.goToSettingsModal();
        settings.inputUrlInFormAndSave(urlPhoto);
    }
}
