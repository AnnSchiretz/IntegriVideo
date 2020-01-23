package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;

public class IntegriVideoSettings extends BasePage {

    private static final By SETTINGS_FORM = By.xpath("//div[@class='integri-user-settings']");
    private static final By EMAIL_INPUT = By.xpath("//form/input[@type='email']");
    private static final By USER_NAME_INPUT = By.xpath("//form/input[@type='text']");
    private static final By PHOTO_URL_INPUT = By.xpath("//form/input[@type='url']");
    private static final By BUTTON_SAVE = By.xpath("//button[contains(text(), 'Save')]");
    private static final By USER_PHOTO_IN_CHAT_WINDOW = By.cssSelector(".integri-user-pic");

    public IntegriVideoSettings(WebDriver driver){
        super(driver);
    }
    @Override
    public void openPage() {
    }

    @Override
    public void isPageOpened() {
    }
    public void inputEmailInFormAndSave(String email){
        driver.findElement(SETTINGS_FORM);
        driver.findElement(EMAIL_INPUT).click();
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(BUTTON_SAVE).click();
    }
    public void inputUserInFormAndSave(String userName){
        wait.until(ExpectedConditions.elementToBeClickable(USER_NAME_INPUT)).click();
        driver.findElement(USER_NAME_INPUT).clear();
        driver.findElement(USER_NAME_INPUT).sendKeys(userName);
        driver.findElement(BUTTON_SAVE).click();
    }
    public void inputUrlInFormAndSave(String photoUrl){
        driver.findElement(PHOTO_URL_INPUT);
        driver.findElement(PHOTO_URL_INPUT).click();
        driver.findElement(PHOTO_URL_INPUT).sendKeys(photoUrl);
        driver.findElement(BUTTON_SAVE).click();
        driver.findElement(USER_PHOTO_IN_CHAT_WINDOW);
    }
    public void validationEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(SETTINGS_FORM));
        String text = wait.until(ExpectedConditions.elementToBeClickable(EMAIL_INPUT)).getAttribute("value");
        assertEquals(email, text, "Message text is not correct");
    }
}
