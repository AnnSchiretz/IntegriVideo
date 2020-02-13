package tests;


import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class SendMessage1000SymbolsTest extends SettingsForTests {
    @Test(description = "Send message with large quantity symbol")
    @Description("Check message 1000 symbol")
    public void sendMessage() {
        chatSteps.sendMessageAndEqualsText(randomMessage().toString(), 1);
    }
    private StringBuilder randomMessage(){
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder();
        int count = 1000;
        for (int i = 0; i < count; i++) {
            randomString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        }
        return randomString;
    }
}

