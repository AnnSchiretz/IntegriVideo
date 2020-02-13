package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class UploadNewUserPhotoTest extends SettingsForTests {
    @Test(description = "Change user photo")
    @Description("Use urlPhoto to change user photo in settings")
    public void loadPhoto() {
        String urlPhoto = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQD-QtTfaj9n5-keZXFCUxOoull1z03cNe83tCQAgAWSpTntPy6&s";
        chatSteps.goToSettingsChat();
        settingsSteps.changePhoto(urlPhoto);
    }
}
