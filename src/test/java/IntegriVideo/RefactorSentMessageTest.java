package IntegriVideo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class RefactorSentMessageTest extends SettingsForTests {
    @Test
    public void sendAndRefactorMessage() {
        String message = "Hello! How are you?";
        String textEdit = "Are you OK?";
        String checkLocator = "//div[@class='integri-chat-message ']/div";
        sendingMessage(message, checkLocator);
        WebElement sentMessage = driver.findElement(By.xpath("//div[contains(text(), 'Hello! How are you?')]/../following-sibling::div/span"));
        sentMessage.click();
        wait.until(ExpectedConditions.visibilityOf(sentMessage));
        driver.findElement(By.cssSelector(".integri-chat-edit-message")).click();
        WebElement messageInput = driver.findElement(By.xpath("//div/textarea"));
        messageInput.clear();
        messageInput.sendKeys(textEdit);
        messageInput.sendKeys(Keys.ENTER);
        String messageAfterEdit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkLocator))).getText();
        assertEquals(messageAfterEdit, textEdit, "Не верное сообщение");
    }
}
