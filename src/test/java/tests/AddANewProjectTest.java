package tests;

import models.Project;
import models.User;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.ProjectPage;

import java.util.ArrayList;
import java.util.Arrays;

public class AddANewProjectTest extends SettingsForTests {
    @Test
    public void signUp(){
        User user = new User("schirets54646@mailinator.com","12345678");
        LogInPage logIn = new LogInPage(driver);
        logIn.openPage();
        ProjectPage projectPage = logIn.logIn(user);
        int count = projectPage.countProjectBeforeCreation();
        createNewProjectAndCheckCreate(count);
    }
     private void createNewProjectAndCheckCreate(int count){
        String symbols = "abcdefghij";
        StringBuilder description = new StringBuilder();
        int countSymbol = 100;
        for (int i = 0; i < countSymbol; i++) {
            description.append(symbols.charAt((int) (Math.random() * symbols.length())));
        }
        Project project = new Project("TUT.BY", description.toString(), new ArrayList<>(Arrays.asList("tut.by", "onliner.by")));
        ProjectPage projectPage = new ProjectPage(driver);
        projectPage.openPage();
        projectPage.createNewProject(project);
        projectPage.checkThatTheProjectWasCreate(count);
    }
}
