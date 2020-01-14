package IntegriVideo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;


public class LoadingOnceImageTest extends SettingsForTests {
    @Test
    public void loadingImg() {
        String pathImg = "src/test/resources/Camera.png";
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".integri-chat-manual-upload"))).click();
        driver.findElement(By.xpath("//span[contains(text(), 'browse')]")).click();
        WebElement inputIMG = driver.findElement(By.xpath("//input[@type='file']"));
        File file = new File(pathImg);
        inputIMG.sendKeys(file.getAbsolutePath());
        driver.findElement(By.xpath("//button[contains(text(), 'Start')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Upload files')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".integri-notify-error"))).isDisplayed();
        String res = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".integri-notify-error"))).getText();
        assertEquals(res, "", "Изображение не загружено!");
    }
}
