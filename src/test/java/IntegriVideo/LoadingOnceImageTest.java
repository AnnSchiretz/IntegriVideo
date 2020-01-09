package IntegriVideo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class LoadingOnceImageTest extends SettingsForTests {
    @Test
    public void loadingImg() {
        String pathImg = "/Users/annschirets/IdeaProjects/IntegriVideo/src/test/java/IntegriVideo/w450h4001385925290Camera — копия.png";
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".integri-chat-manual-upload"))).click();
        driver.findElement(By.xpath("//span[contains(text(), \"browse\")]")).click();
        driver.findElement(By.xpath("//input[@type=\"file\"]")).sendKeys(pathImg);
        driver.findElement(By.xpath("//button[contains(text(), \"Start\")]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), \"Upload files\")]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".integri-notify-error"))).isDisplayed();
        String res = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".integri-notify-error"))).getText();
        assertEquals(res, "", "Изображение не загружено!");
    }
}
