package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class IntegriVideoUploadImages extends BasePage {

    private static final By BUTTON_BROWSE = By.xpath("//span[contains(text(), \"browse\")]");
    private static final By ADD_IMG_INPUT = By.xpath("//input[@type=\"file\"]");
    private static final By BUTTON_START = By.xpath("//button[contains(text(), \"Start\")]");
    private static final By UPLOAD_PROGRESS = By.xpath("//div[contains(text(), \"Upload files\")]");
    private static final By ERROR_UPLOAD = By.cssSelector(".integri-notify-error");
    private static final By UPLOADING_FILE_LIST = By.xpath("//div[@class='integri-file-upload-filelist']/div");

    public IntegriVideoUploadImages(WebDriver driver) {
        super(driver);
    }

    public void uploadImg(int count, String... pathImg){
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_BROWSE)).click();
        WebElement inputIMG = driver.findElement(ADD_IMG_INPUT);
        String path = Arrays.toString(pathImg).replaceAll("\\[", "");
        String pathResult = path.replaceAll("]", "");
        for (int i = 0; i < count; i++) {
            File file = new File(pathResult);
            inputIMG.sendKeys(file.getAbsolutePath());
        }
        driver.findElement(BUTTON_START).click();
        List<WebElement> files = driver.findElements(UPLOADING_FILE_LIST);
        assertEquals(files.size(), count, "Неверное количество файлов");
        wait.until(ExpectedConditions.visibilityOfElementLocated(UPLOAD_PROGRESS));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_UPLOAD)).isDisplayed();
        String res = wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_UPLOAD)).getText();
        assertEquals(res, "", "Указаное количество изображений не загружено!");
    }

}
