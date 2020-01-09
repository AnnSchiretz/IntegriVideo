package IntegriVideo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class EmptyEditSentMessageTest extends SettingsForTests {
    @Test
    public void sentEmptyEditMessage() {
        String checkLocator = "//div[contains(text(), 'Hello, again')]";
        String message = "Hello, again";
        sendMessage(message, checkLocator);
        makeMessageEmpty();
        sendEmptyMessage();
    }

    private void makeMessageEmpty() {
        driver.findElement(By.xpath("//div[contains(text(), 'Hello, again')]/../following-sibling::div/span")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(), 'Hello, again')]/../following-sibling::div/span"))));
        driver.findElement(By.cssSelector(".integri-chat-edit-message")).click();
        driver.findElement(By.xpath("//div/textarea")).clear();
    }

    private void sendEmptyMessage() {
        WebElement messageInput = driver.findElement(By.xpath("//div/textarea"));
        messageInput.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(), 'Message cannot be empty!')]"))));
    }
}
