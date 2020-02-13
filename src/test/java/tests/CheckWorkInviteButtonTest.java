package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;


public class CheckWorkInviteButtonTest extends SettingsForTests {
    @Test(description = "click invite button")
    @Description("check opening link in new tab")
    public void clickInviteButton() throws IOException, UnsupportedFlavorException {
        chatSteps.copyInvitationLink();
        String textInBuffer = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        ((JavascriptExecutor) driver).executeScript("window.open();");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(textInBuffer);
    }
}
