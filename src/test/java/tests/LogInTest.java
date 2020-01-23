package tests;

import models.User;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.ProjectPage;

public class LogInTest extends SettingsForTests {
    @Test
    public void logIn(){
        User user = new User("schirets54646@mailinator.com","111111112");
        LogInPage logIn = new LogInPage(driver);
        logIn.openPage();
        ProjectPage projectPage = logIn.logIn(user);
    }
}
