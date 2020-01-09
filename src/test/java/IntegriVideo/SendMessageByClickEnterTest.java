package IntegriVideo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SendMessageByClickEnterTest extends SettingsForTests {

    @Test
    public void sendMessage() {
        driver.findElement(By.xpath("//textarea")).sendKeys("Hello!");
        WebElement messageInput = driver.findElement(By.xpath("//textarea"));
        messageInput.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[contains(text(),'Hello!')]"));
    }
}
