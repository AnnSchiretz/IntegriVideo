package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class CheckWorkButtonCopyTest extends SettingsForTests {
    @Test(description = "click button copy code")
    @Description("check code in buffer")
    public void clickCopyButton() throws IOException, UnsupportedFlavorException {
       chatSteps.copyCodeAndValidate();
    }
}
