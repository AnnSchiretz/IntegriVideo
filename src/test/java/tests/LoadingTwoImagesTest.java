package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class LoadingTwoImagesTest extends SettingsForTests {
    @Test(description = "upload two images")
    @Description("upload two images")
    public void loadingTwoImg() {
        String pathImg = "src/test/resources/Camera.png";
        chatSteps.goToFileUpload();
        uploadSteps.uploadImages(2, pathImg);
    }
}
