package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class EditUserNameTest extends SettingsForTests {
    @Test(description = "Edit user name")
    @Description("check user name after edit")
    public void editName() {
        String newName = "LionGuest";
        chatSteps.goToSettingsChat();
        settingsSteps.changeName(newName);
        driver.navigate().refresh();
        chatSteps.checkUserName(newName);
    }
}
