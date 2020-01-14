package IntegriVideo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;


public class CheckWorkInviteButtonTest extends SettingsForTests {
    @Test
    public void clickInviteButton() throws IOException, UnsupportedFlavorException {
        driver.findElement(By.id("invite-users-to-chat")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Link was copied')]/following-sibling::a")).isDisplayed();
        String textInBuffer = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        ((JavascriptExecutor) driver).executeScript("window.open();");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(textInBuffer);
    }
}
