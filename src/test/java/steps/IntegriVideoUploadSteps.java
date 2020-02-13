package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.IntegriVideoUploadImages;

public class IntegriVideoUploadSteps {
    IntegriVideoUploadImages upload;

    public IntegriVideoUploadSteps(WebDriver driver){
        upload = new IntegriVideoUploadImages(driver);
    }

    @Step("Upload images in settings modal")
    public IntegriVideoUploadSteps uploadImages(int count, String ...args){
        upload.uploadImg(count,args);
        return this;
    }
}
