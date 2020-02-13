package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class EditLastProjectTest extends SettingsForTests {
    @Test(description = "click button copy code")
    @Description("check code in buffer")
    public void editLastProject(){
        User user = new User("schirets54646@mailinator.com","12345678");
        String addDomain = "12345999999.by";
        ArrayList<String> listDomains = new ArrayList<>(Arrays.asList("tut.by", "onliner.by"));
        logInSteps.loginInSystem(user);
        projectSteps.editLastProject(addDomain, listDomains);
    }
}
