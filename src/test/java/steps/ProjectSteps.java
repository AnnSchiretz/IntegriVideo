package steps;

import io.qameta.allure.Step;
import models.Project;
import org.openqa.selenium.WebDriver;
import pages.ProjectPage;

import java.util.ArrayList;

public class ProjectSteps {
    private ProjectPage systemProject;

    public ProjectSteps(WebDriver driver){
        systemProject = new ProjectPage(driver);
    }
    @Step("add new project")
    public ProjectSteps addNewProject(Project project){
        systemProject.openPage();
        int count = systemProject.countProjectBeforeCreation();
        systemProject.createNewProject(project)
                .checkThatTheProjectWasCreate(count);
        return this;
    }
    @Step("add new component")
    public ProjectSteps addNewComponentToProject(String name){
        systemProject.addNewComponent(name)
                    .checkUpdateComponent();
        return this;
    }
    @Step("edit last project")
    public ProjectSteps editLastProject(String domain, ArrayList<String> domainList){
        systemProject.clickLastCreateProject()
                .addNewDomainsInProject(domain, domainList);
        return this;
    }
}
