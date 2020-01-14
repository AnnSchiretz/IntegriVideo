package IntegriVideo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class LoadingTwoImagesTest extends SettingsForTests {
    @Test
    public void loadingTwoImg() {
        String pathImg = "src/test/resources/Camera.png";
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".integri-chat-manual-upload"))).click();
        driver.findElement(By.xpath("//span[contains(text(), \"browse\")]")).click();
        WebElement inputIMG = driver.findElement(By.xpath("//input[@type='file']"));
        File file = new File(pathImg);
        inputIMG.sendKeys(file.getAbsolutePath());
        inputIMG.sendKeys(file.getAbsolutePath());
        List<WebElement> files = driver.findElements(By.xpath("//div[@class=\"integri-file-upload-filelist\"]/div"));
        assertEquals(files.size(), 2, "Неверное количество файлов");
        driver.findElement(By.xpath("//button[contains(text(), \"Start\")]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), \"Upload files\")]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".integri-notify-error"))).isDisplayed();
        String res = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".integri-notify-error"))).getText();
        assertEquals(res, "", "Изображения не загружены!");
    }
}
