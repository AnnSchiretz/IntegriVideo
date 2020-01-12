package IntegriVideo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class EditUserEmailTest extends SettingsForTests {
    @Test
    public void editEmail() {
        String newEmail = "123456@gmail.com";
        By settingsXPATH = By.xpath("//span[@class='integri-chat-settings integri-pointer']");
        By formXpath = By.xpath("//form/input[@type='email']");
        WebElement settings = driver.findElement(By.xpath("//span[@class='integri-chat-settings integri-pointer']"));
        WebElement form = driver.findElement(By.xpath("//form/input[@type='email']"));

        wait.until(ExpectedConditions.elementToBeClickable(settings)).click();
        wait.until(ExpectedConditions.elementToBeClickable(form)).click();
        form.sendKeys(newEmail);
        driver.findElement(By.xpath("//button[contains(text(), 'Save')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".integri-chat-session")));
        driver.navigate().refresh();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("integri-component-chat")));
        wait.until(ExpectedConditions.elementToBeClickable(settingsXPATH)).click();
        String result = wait.until(ExpectedConditions.elementToBeClickable(formXpath)).getAttribute("value");
        assertEquals(newEmail, result, "Неверный email!");
    }
}
