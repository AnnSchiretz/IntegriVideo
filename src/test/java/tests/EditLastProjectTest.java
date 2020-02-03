package tests;

import models.User;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.ProjectPage;

import java.util.ArrayList;
import java.util.Arrays;

public class EditLastProjectTest extends SettingsForTests {
    @Test
    public void editLastProject(){
        String addDomain = "12345999999.by";
        ArrayList<String> listDomains = new ArrayList<>(Arrays.asList("tut.by", "onliner.by"));
        ProjectPage projectPage = logIn();
        projectPage.clickLastCreateProject()
                .addNewDomainsInProject(addDomain, listDomains);

    }
    private ProjectPage logIn(){
        User user = new User("schirets54646@mailinator.com","12345678");
        LogInPage logIn = new LogInPage(driver);
        logIn.openPage();
        ProjectPage projectPage = logIn.logIn(user);
        return projectPage;
    }

}
