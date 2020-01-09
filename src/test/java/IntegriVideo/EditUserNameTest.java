package IntegriVideo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EditUserNameTest extends SettingsForTests {
    @Test
    public void editName() {
        String newName = "LionGuest";
        driver.findElement(By.xpath("//span[@class=\"integri-chat-settings integri-pointer\"]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"integri-modal-content\"]//form/input"))).click();
        driver.findElement(By.xpath("//form/input[@type=\"text\"]")).clear();
        driver.findElement(By.xpath("//form/input[@type=\"text\"]")).sendKeys(newName);
        driver.findElement(By.xpath("//button[contains(text(), \"Save\")]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".integri-chat-session")))).click();
        String result = driver.findElement(By.xpath("//div[@class=\"integri-session-user-name\"]")).getText();
        assertEquals(newName, result, "Неверное имя!");
    }
}
