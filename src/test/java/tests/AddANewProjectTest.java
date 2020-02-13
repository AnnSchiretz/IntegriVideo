package tests;

import io.qameta.allure.Description;
import models.Project;
import models.User;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class AddANewProjectTest extends SettingsForTests {
    @Test(description = "Add new project in system")
    @Description("check project was create")
    public void signUp(){
        User user = new User("schirets54646@mailinator.com","12345678");
        logInSteps.loginInSystem(user);
        createNewProjectAndCheckCreate();
    }
     private void createNewProjectAndCheckCreate(){
        String symbols = "abcdefghij";
        StringBuilder description = new StringBuilder();
        int countSymbol = 100;
        for (int i = 0; i < countSymbol; i++) {
            description.append(symbols.charAt((int) (Math.random() * symbols.length())));
        }
        Project project = new Project("TUT.BY", description.toString(), new ArrayList<>(Arrays.asList("tut.by", "onliner.by")));
        projectSteps.addNewProject(project);
    }
}
