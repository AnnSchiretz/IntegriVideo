package pages;

import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class ProjectPage extends BasePage {

    @FindBy(css = ".new")
    WebElement addNewProject;
    @FindBy(name = "name")
    WebElement inputProjectName;
    @FindBy(xpath = "//textarea[@name= 'description']")
    WebElement inputDescriptionProject;
    @FindBy(name= "domains[]")
    WebElement inputProjectDomains;
    @FindBy(xpath = "//div[@id=\"project-form\"]//button")
    WebElement buttonCreate;
    @FindBy(id="project-view")
    WebElement projectPage;
    @FindBy(xpath = "//a[contains(text(), 'Edit')]")
    WebElement editProject;
    @FindBy(xpath = "//div[@class ='component new']")
    WebElement addNewComponent;
    @FindBy(css = ".select2-selection__arrow")
    WebElement componentType;
    @FindBy(name="name")
    WebElement componentName;
    @FindBy(xpath = "//div[@id='component-form']//button")
    WebElement createComponent;
    @FindBy(xpath = "//button[contains(text(), 'Update')]")
    WebElement updateComponent;
    @FindBy (css = ".nav-link")
    WebElement returnToProjects;


    private static final By DOMAINS_COUNT = By.xpath("//div[@class='form-group domains']/div/input");
    private static final By COUNT_PROJECT = By.xpath("//div[@id='project-list']/div/div");
    private static final By TYPE_COMPONENT = By.xpath("//ul[@class='select2-results__options']/li");
    private static final By SELECTED_TYPE = By.xpath("//span[@role='combobox']/span");
    private static final By EDIT_PROFILE =  By.xpath("//a[contains(text(), 'Edit')]");

    public ProjectPage(WebDriver driver) {
        super(driver);
    }
    public void openPage(){
        driver.get("https://dev.integrivideo.com/app/projects");
        isPageOpened();
        PageFactory.initElements(driver, ProjectPage.this);
    }

    public void isPageOpened(){
        try{
            driver.findElement(By.cssSelector(".new"));
        } catch (TimeoutException ex){
            System.out.println("Не отобразились элементы!");
            throw new TimeoutException ("Не отобразились элементы!");
        }
    }
    public int countProjectBeforeCreation(){
        List<WebElement> project = driver.findElements(COUNT_PROJECT);
        return project.size();
    }
    public void checkThatTheProjectWasCreate(int countBeforeCreate){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(COUNT_PROJECT));
        List<WebElement> project = driver.findElements(COUNT_PROJECT);
        int countAfterCreate = project.size();
        assertEquals(countBeforeCreate + 1, countAfterCreate, "Не был создан новый проект!");
    }
    public void createNewProject(Project project){
        PageFactory.initElements(driver, ProjectPage.this);
        addNewProject.click();
        inputProjectName.sendKeys(project.getNameProject());
        wait.until(ExpectedConditions.elementToBeClickable(inputDescriptionProject));
        inputDescriptionProject.sendKeys(project.getDescriptionProject());
        for( int i = 0; i< project.getDomains().size(); i ++){
            driver.findElements(By.name("domains[]")).get(i).sendKeys(project.getDomains().get(i));
        }
        buttonCreate.click();
    }
    public ProjectPage clickLastCreateProject(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(COUNT_PROJECT));
        List<WebElement> project = driver.findElements(COUNT_PROJECT);
        WebElement lastProject = project.get(project.size() - 2);
        lastProject.click();
        return this;
    }
    private void addNewDomain(String string){
        PageFactory.initElements(driver, ProjectPage.this);
        List<WebElement> inputDomain = driver.findElements(DOMAINS_COUNT);
        inputDomain.get(inputDomain.size() - 1).sendKeys( string);
        buttonCreate.click();
    }
    public void addNewDomainsInProject(String addDomain,ArrayList<String> string){
        PageFactory.initElements(driver, ProjectPage.this);
        editProject.click();
        addNewDomain(addDomain);
        checkAddingDomain(addDomain);
    }
    private void checkAddingDomain(String addDomain){
        wait.until(ExpectedConditions.visibilityOfElementLocated(COUNT_PROJECT));
        clickLastCreateProject();
        wait.until(ExpectedConditions.visibilityOf(projectPage));
        editProject.click();
        List<WebElement> inputDomain = driver.findElements(DOMAINS_COUNT);
        WebElement lastInput = inputDomain.get(inputDomain.size() - 2);
        String resultInProjectPageDomain = wait.until(ExpectedConditions.visibilityOf(lastInput)).getAttribute("value");
        assertEquals(resultInProjectPageDomain, addDomain, "Не совпали домены при проверке после добавления");
    }
    public ProjectPage addNewComponent(String name){
        clickLastCreateProject();
        PageFactory.initElements(driver, ProjectPage.this);
        addNewComponent.click();
        selectAComponentType();
        addComponentName(name);
        createComponent.click();
        wait.until(ExpectedConditions.visibilityOf(updateComponent));
        return this;
    }
    private void selectAComponentType(){
        String typeBeforeSelect = driver.findElement(SELECTED_TYPE).getText();
        componentType.click();
        int numberType = (int) (1 + Math.random() * 3);
        List<WebElement> typeComponent = driver.findElements(TYPE_COMPONENT);
        WebElement choiceComponent = typeComponent.get(typeComponent.size() - numberType);
        choiceComponent.click();
        String selectedType = driver.findElement(SELECTED_TYPE).getText();
        assertNotEquals(typeBeforeSelect, selectedType, "не произошел выбор, либо числа так совпали, что произошел выбор того же типа, что и был");
    }
    private void addComponentName(String name){
        componentName.click();
        componentName.sendKeys(name);
    }
    public ProjectPage checkUpdateComponent(){
        returnToProjects.click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(COUNT_PROJECT));
        List<WebElement> project = driver.findElements(COUNT_PROJECT);
        WebElement lastProject = project.get(project.size() - 2);
        String countComponent = lastProject.getText();
        char count = countComponent.charAt(18);
        assertNotEquals(count, 0, "Не создались компоненты!");
        return this;
    }
}
