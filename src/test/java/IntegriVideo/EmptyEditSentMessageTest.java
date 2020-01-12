package IntegriVideo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class EmptyEditSentMessageTest extends SettingsForTests {
    @Test
    public void sentEmptyEditMessage() {
        String checkLocator = "//div[@class='integri-chat-message ']/div";
        String message = "Hello, again";
        sendingMessage(message, checkLocator);
        makeMessageEmpty();
        sendEmptyMessage();
    }

    private void makeMessageEmpty() {
        WebElement message = driver.findElement(By.xpath("//div[contains(text(), 'Hello, again')]/../following-sibling::div/span"));
        message.click();
        wait.until(ExpectedConditions.visibilityOf(message));
        driver.findElement(By.cssSelector(".integri-chat-edit-message")).click();
    }

    private void sendEmptyMessage() {
        WebElement messageInput = driver.findElement(By.xpath("//div/textarea"));
        messageInput.clear();
        messageInput.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(text(), 'Message cannot be empty!')]"))));
    }
}
