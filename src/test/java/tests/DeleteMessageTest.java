package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DeleteMessageTest extends SettingsForTests {
    @Test(description = "Send message and delete it in chat window")
    @Description("check alert visibility at process delete message")
    public void sendMessage() {
        String message = "Hello";
        chatSteps.sendMessage(message)
                .deleteMessage(1);
        moveAndAcceptAlert();
    }

    private void moveAndAcceptAlert() {
        Alert alert = driver.switchTo().alert();
        String alertResult = alert.getText();
        assertEquals(alertResult, "Are you sure to delete message?", "Неверное сообщение в аллерте");
        alert.accept();
        driver.navigate().refresh();
    }
}
