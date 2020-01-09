package IntegriVideo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class UploadNewUserPhotoTest extends SettingsForTests {
    @Test
    public void loadPhoto() {
        driver.findElement(By.cssSelector(".integri-session-anonymous"));
        String urlPhoto = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQD-QtTfaj9n5-keZXFCUxOoull1z03cNe83tCQAgAWSpTntPy6&s";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"integri-chat-settings integri-pointer\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/input[@type=\"email\"]"))).click();
        driver.findElement(By.xpath("//form/input[@type=\"url\"]")).sendKeys(urlPhoto);
        driver.findElement(By.xpath("//button[contains(text(), \"Save\")]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("integri-component-chat")));
        driver.findElement(By.cssSelector(".integri-user-pic"));
    }
}
