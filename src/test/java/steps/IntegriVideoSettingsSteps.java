package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.IntegriVideoSettings;

public class IntegriVideoSettingsSteps {
    private IntegriVideoSettings settings;

    public IntegriVideoSettingsSteps(WebDriver driver){
        settings = new IntegriVideoSettings(driver);
    }

    @Step("Change user email in chat settings")
    public IntegriVideoSettingsSteps changeEmail(String email){
        settings.inputEmailInFormAndSave(email);
        return this;
    }
    @Step("Change user photo in chat settings")
    public IntegriVideoSettingsSteps changePhoto(String urlPhoto){
        settings.inputUrlInFormAndSave(urlPhoto);
        return this;
    }
    @Step("Change user photo in chat settings")
    public IntegriVideoSettingsSteps changeName(String name){
        settings.inputUserInFormAndSave(name);
        return this;
    }
    @Step("validation email after changing")
    public IntegriVideoSettingsSteps validationNewEmail(String email){
        settings.validationEmail(email);
        return this;
    }
}
