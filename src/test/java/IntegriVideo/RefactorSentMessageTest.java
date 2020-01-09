package IntegriVideo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class RefactorSentMessageTest extends SettingsForTests {
    @Test
    public void sendAndRefactorMessage() {
        String message = "Hello! How are you?";
        String checkLocator = "//div[contains(text(),'Hello! How are you?')]";
        sendMessage(message, checkLocator);
        driver.findElement(By.xpath("//div[contains(text(), 'Hello! How are you?')]/../following-sibling::div/span")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(), 'Hello! How are you?')]/../following-sibling::div/span"))));
        driver.findElement(By.cssSelector(".integri-chat-edit-message")).click();
        driver.findElement(By.xpath("//div/textarea")).clear();
        driver.findElement(By.xpath("//div/textarea")).sendKeys("Are you OK?");
        WebElement messageInput = driver.findElement(By.xpath("//div/textarea"));
        messageInput.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(),'Are you OK?')]"))));
    }
}
