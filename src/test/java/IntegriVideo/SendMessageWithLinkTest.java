package IntegriVideo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SendMessageWithLinkTest extends SettingsForTests {
    @Test
    public void sendMessageWithLink() {
        String message = "Hello! https://habr.com/ru/";
        String checkLocator = "//div[@class='integri-chat-message ']/div";
        sendingMessage(message, checkLocator);
        driver.findElement(By.xpath("//a[contains(text(), \"https://habr.com/ru/\")]")).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='TMpanel']")));
    }
}
