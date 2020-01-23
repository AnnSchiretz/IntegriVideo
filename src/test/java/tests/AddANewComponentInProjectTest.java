package tests;

import models.User;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.ProjectPage;

public class AddANewComponentInProjectTest extends SettingsForTests {
    @Test
    public void addNewComponent(){
        String nameComponent = "alallala";
        User user = new User("schirets54646@mailinator.com","12345678");

        LogInPage logIn = new LogInPage(driver);
        logIn.openPage();
        ProjectPage projectPage = logIn.logIn(user);
        projectPage.addNewComponent(nameComponent)
                .checkUpdateComponent();
    }
}
