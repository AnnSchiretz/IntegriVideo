package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;


public class LoadingOnceImageTest extends SettingsForTests {
    @Test(description = "Upload once .png file")
    @Description("upload images in chat window")
    public void loadingImg() {
        String pathImg = "src/test/resources/Camera.png";
        chatSteps.goToFileUpload();
        uploadSteps.uploadImages(1, pathImg);
    }
}
