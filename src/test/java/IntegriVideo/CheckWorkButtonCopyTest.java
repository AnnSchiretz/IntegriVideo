package IntegriVideo;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static org.testng.Assert.*;

public class CheckWorkButtonCopyTest extends SettingsForTests {
    @Test
    public void clickCopyButton() throws IOException, UnsupportedFlavorException {
        String textOnPage = driver.findElement(By.xpath("//code")).getText();
        String copyRefactorText = textOnPage.replaceAll("\n", "");
        driver.findElement(By.cssSelector(".component-code")).click();
        driver.findElement(By.xpath("//span[contains(text(), \"Code was copied\")]")).isDisplayed();
        String textInBuffer = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        assertEquals(copyRefactorText, textInBuffer, "Не совпала информация с DOM и в буфере обмена");
    }
}
