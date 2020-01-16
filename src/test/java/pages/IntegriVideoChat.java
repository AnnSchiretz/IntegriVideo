package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class IntegriVideoChat extends BasePage {
    private static final By INPUT_MESSAGE = By.xpath("//textarea");
    private static final By MESSAGE_IN_WINDOW = By.xpath("//div[@class='integri-chat-message-text']");
    private static final By BUTTON_SEND_MESSAGE = By.xpath("//button[@title='Send message']");
    private static final By BUTTON_COPY_CODE = By.xpath("//code");
    private static final By BUTTON_INVITE = By.id("invite-users-to-chat");
    private static final By BUTTON_DELETE_MESSAGE = By.cssSelector(".iv-icon-trash2");
    private static final By USER_NAME_IN_CHAT_WINDOW = By.xpath("//span[@class='integri-session-user-name']");
    private static final By BUTTON_EDIT_MESSAGE = By.cssSelector(".integri-chat-edit-message");
    private static final By TRIAL_VERSION_MESSAGE = By.xpath("//div[contains(text(),'This is trial version')]");
    private static final By TRIAL_VERSION_CLICK_SKIP = By.cssSelector(".close-demo-screen");
    private static final By LINK_IN_MESSAGE = By.xpath("//div[@class='integri-chat-message-text']/a");
    private static final By ALERT_THEN_MESSAGE_EMPTY = By.xpath("//div[contains(text(), 'Message cannot be empty!')]");
    private static final By FIELD_EDIT_MESSAGE = By.xpath("//div/textarea");
    private static final By GET_COUNT_MESSAGE = By.cssSelector(".integri-chat-messages");
    private static final By MESSAGE_AFTER_COPY_MESSAGE = By.xpath("//span[contains(text(), 'Code was copied')]");
    private static final By ALERT_AFTER_CLICK_INVITE_BUTTON = By.xpath("//span[contains(text(),'Link was copied')]/following-sibling::a");
    private static final By BUTTON_SETTINGS = By.xpath("//span[@class='integri-chat-settings integri-pointer']");
    private static final By BUTTON_MANUAL_UPLOAD = By.cssSelector(".integri-chat-manual-upload");

    public IntegriVideoChat(WebDriver driver){
       super(driver);
    }
    public void sendMessage(String message){
        driver.findElement(INPUT_MESSAGE).sendKeys(message);
        driver.findElement(BUTTON_SEND_MESSAGE).click();
    }
    public void makeMessageEmptyAndSend(){
        driver.findElement(MESSAGE_IN_WINDOW).click();
        driver.findElement(BUTTON_EDIT_MESSAGE).click();
        driver.findElement(FIELD_EDIT_MESSAGE).clear();
        driver.findElement(FIELD_EDIT_MESSAGE).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_THEN_MESSAGE_EMPTY));
    }
    public void messageShouldContainText(String message, int messageNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(MESSAGE_IN_WINDOW));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(MESSAGE_IN_WINDOW, messageNumber - 1));
        String text = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MESSAGE_IN_WINDOW)).get(messageNumber - 1).getText();
        assertEquals(message, text, "Message text is not correct");
    }
    public void setMessage(String message){
        wait.until(ExpectedConditions.elementToBeClickable(INPUT_MESSAGE)).click();
        driver.findElement(INPUT_MESSAGE).sendKeys(message);
    }
    public void inputTextInEditInputAndSendMessage(String editMessage){
        driver.findElement(FIELD_EDIT_MESSAGE).click();
        driver.findElement(FIELD_EDIT_MESSAGE).clear();
        driver.findElement(FIELD_EDIT_MESSAGE).sendKeys(editMessage);
        driver.findElement(FIELD_EDIT_MESSAGE).sendKeys(Keys.ENTER);
    }
    public int getCountMessage(){
        int result = driver.findElements(GET_COUNT_MESSAGE).size();
        return result;
    }
    public void goToSettingsModal(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_SETTINGS)).click();
    }
    public void goToFileUpload(){
        driver.findElement(BUTTON_MANUAL_UPLOAD).click();
    }
    public void clickSendMessage(){
        driver.findElement(BUTTON_SEND_MESSAGE).click();
    }
    public void sendMessageByEnter(){
        driver.findElement(BUTTON_SEND_MESSAGE).sendKeys(Keys.ENTER);
    }
    public String clickCopyCode(){
        String result =  driver.findElement(BUTTON_COPY_CODE).getText();
        driver.findElement(BUTTON_COPY_CODE).click();
        driver.findElement(MESSAGE_AFTER_COPY_MESSAGE).isDisplayed();
        return result;
    }
    public void clickInviteButton(){
        driver.findElement(BUTTON_INVITE).click();
        driver.findElement(ALERT_AFTER_CLICK_INVITE_BUTTON).isDisplayed();
    }
    public void deleteMessage(){
        wait.until(ExpectedConditions.elementToBeClickable(MESSAGE_IN_WINDOW));
        driver.findElement(BUTTON_DELETE_MESSAGE).click();
    }
    public void clickEditMessage(){
        driver.findElement(BUTTON_EDIT_MESSAGE).click();
    }
    public void validationUserName(String nameUser){
        wait.until(ExpectedConditions.visibilityOfElementLocated(USER_NAME_IN_CHAT_WINDOW));
        String newName = driver.findElement(USER_NAME_IN_CHAT_WINDOW).getText();
        assertEquals(newName, nameUser, "Не совпали именя порсле изменения в настройкках");
    }
    public void skipTrialVersion(){
        driver.findElement(TRIAL_VERSION_MESSAGE);
        driver.findElement(TRIAL_VERSION_CLICK_SKIP).click();
    }
    public void followingTheLinkInMessage(){
        driver.findElement(LINK_IN_MESSAGE).click();
    }
    public void moveToAnotherTabs(int numberTab, String locator){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(numberTab));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
}
