package steps;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.LogInPage;

public class LogInSteps {
    private LogInPage login;

    public LogInSteps (WebDriver driver){
        login = new LogInPage(driver);
    }
    @Step("log in user in system")
    public LogInSteps loginInSystem(User user){
        login.openPage();
        login.logIn(user);
        return this;
    }
    @Step("return user password")
    public LogInSteps forgotPassword(User user){
        login.openPage();
        login.goToForgotPassword(user);
        return this;
    }
}
