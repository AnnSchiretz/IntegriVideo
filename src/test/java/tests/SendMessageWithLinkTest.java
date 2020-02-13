package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class SendMessageWithLinkTest extends SettingsForTests {
    @Test(description = "Send message ")
    @Description("Send message with link")
    public void sendMessageWithLink() {
        String message = "Hello! https://habr.com/ru/";
        String locator = "//div[@id='TMpanel']";
        chatSteps.sendMessageAndEqualsText(message, 1)
                .goToLinkAndMoveToThisTab(1, locator);
    }
}
