package tests;


import org.testng.annotations.Test;
import pages.IntegriVideoChat;

public class SendMessage1000SymbolsTest extends SettingsForTests {
    IntegriVideoChat chat;
    @Test
    public void sendMessage() {
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder();
        int count = 1000;
        for (int i = 0; i < count; i++) {
            randomString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        }
        chat = new IntegriVideoChat(driver);
        chat.sendMessage(randomString.toString());
        chat.messageShouldContainText(randomString.toString(), 1);
    }
}

