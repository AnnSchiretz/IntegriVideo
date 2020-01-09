package IntegriVideo;


import org.testng.annotations.Test;

public class SendMessage1000SymbolsTest extends SettingsForTests {
    @Test
    public void sendMessage() {
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder randomString = new StringBuilder();
        int count = 1000;
        for (int i = 0; i < count; i++) {
            randomString.append(symbols.charAt((int) (Math.random() * symbols.length())));
        }
        String checkLocator = "//div[contains(text(),'" + randomString + "')]";
        sendMessage(randomString.toString(),checkLocator);
    }
}

