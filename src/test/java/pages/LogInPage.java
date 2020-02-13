package pages;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

public class LogInPage extends BasePage {
    @FindBy(name = "email")
    WebElement emailInput;
    @FindBy(name = "password")
    WebElement passwordInput;
    @FindBy(id = "login-form")
    WebElement form;
    @FindBy(css = ".forgot")
    WebElement forgotPassword;
    @FindBy(xpath = "//button")
    WebElement recoveryPassword;

    private static final By MESSAGE_ALERT = By.xpath("//span[contains(text(), 'Message with instructions was sent')]");

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void openPage(){
        driver.get("https://dev.integrivideo.com/login");
        isPageOpened();
        PageFactory.initElements(driver, LogInPage.this);
    }
    public void isPageOpened(){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form")));
        } catch (TimeoutException ex){
            System.out.println("Не отобразились элементы!");
            AllureUtils.takeScreenshot(driver);
            throw new TimeoutException ("Не отобразились элементы!");
        }
    }
    @Step("user login steps")
    public ProjectPage logIn(User user){
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        form.submit();
        AllureUtils.takeScreenshot(driver);
        ProjectPage project = new ProjectPage(driver);
        project.isPageOpened();
        return project;
    }
    @Step("recovery password")
    public void goToForgotPassword(User user){
        forgotPassword.click();
        emailInput.sendKeys(user.getEmail());
        recoveryPassword.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_ALERT));
        AllureUtils.takeScreenshot(driver);
    }
}

