package tests;

import org.testng.annotations.Test;
import pages.IntegriVideoChat;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class CheckWorkButtonCopyTest extends SettingsForTests {
    IntegriVideoChat chat;
    @Test
    public void clickCopyButton() throws IOException, UnsupportedFlavorException {
        chat = new IntegriVideoChat(driver);
        String textOnPage = chat.clickCopyCode();
        String copyRefactorText = textOnPage.replaceAll("\n", "");
        String textInBuffer = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        assertEquals(copyRefactorText, textInBuffer, "Не совпала информация с DOM и в буфере обмена");
    }
}
