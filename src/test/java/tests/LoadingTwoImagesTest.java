package tests;

import org.testng.annotations.Test;
import pages.IntegriVideoChat;
import pages.IntegriVideoUploadImages;

public class LoadingTwoImagesTest extends SettingsForTests {
    IntegriVideoChat chat;
    IntegriVideoUploadImages upload;
    @Test
    public void loadingTwoImg() {
        String pathImg = "src/test/resources/Camera.png";
        chat = new IntegriVideoChat(driver);
        upload = new IntegriVideoUploadImages(driver);
        chat.goToFileUpload();
        upload.uploadImg( 2, pathImg);
    }
}
