package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.annotations.Test;

public class LogInTest extends SettingsForTests {
    @Test(description = "Log in system")
    @Description("Log in system")
    public void logIn(){
        User user = new User("schirets54646@mailinator.com","12345678");
        logInSteps.loginInSystem(user);
    }
}
