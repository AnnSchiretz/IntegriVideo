package IntegriVideo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EditUserNameTest extends SettingsForTests {
    @Test
    public void editName() {
        String newName = "LionGuest";
        WebElement form = driver.findElement(By.xpath("//form/input[@type='text']"));
        driver.findElement(By.xpath("//span[@class='integri-chat-settings integri-pointer']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='integri-modal-content']//form/input"))).click();
        form.clear();
        form.sendKeys(newName);
        driver.findElement(By.xpath("//button[contains(text(), 'Save')]")).click();
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("integri-component-chat")));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".integri-chat-session"))).click();
        String result = driver.findElement(By.xpath("//div[@class='integri-session-user-name']")).getText();
        assertEquals(newName, result, "Неверное имя!");
    }
}
