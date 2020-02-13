package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import models.User;
import org.testng.annotations.Test;

public class AddANewComponentInProjectTest extends SettingsForTests {
    @Test(description = "Add a new component in project")
    @Description("check component is create")
    @Link("https://dev.integrivideo.com/app/projects")
    @Issue("project")
    @TmsLink("project")
    public void addNewComponent(){
        String nameComponent = "component name";
        User user = new User("schirets54646@mailinator.com","12345678");

        logInSteps.loginInSystem(user);
        projectSteps.addNewComponentToProject(nameComponent);
    }
}
