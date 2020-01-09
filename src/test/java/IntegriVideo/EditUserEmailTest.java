package IntegriVideo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EditUserEmailTest extends SettingsForTests {
    @Test
    public void editEmail() {
        String newEmail = "123456@gmail.com";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"integri-chat-settings integri-pointer\"]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/input[@type=\"email\"]"))).click();
        driver.findElement(By.xpath("//form/input[@type=\"email\"]")).sendKeys(newEmail);
        driver.findElement(By.xpath("//button[contains(text(), \"Save\")]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".integri-chat-session")));
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("integri-component-chat")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class=\"integri-chat-settings integri-pointer\"]"))).click();
        String result = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form/input[@type=\"email\"]"))).getAttribute("value");
        assertEquals(newEmail, result, "Неверный email!");
    }
}
