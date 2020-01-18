package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class IntegriVideoChat extends BasePage {
    private static final By INPUT_MESSAGE = By.xpath("//textarea");
    private static final By COUNT_MESSAGES_IN_CHAT_WINDOW = By.cssSelector(".integri-chat-messages .integri-chat-message-own");
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
    private static final By ALERT_THEN_MESSAGE_EMPTY = By.cssSelector(".integri-notify-error");
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
    public void deleteMessage(int countMessage){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MESSAGE_IN_WINDOW));
        List<WebElement> message = driver.findElements(MESSAGE_IN_WINDOW);
        Actions actions = new Actions(driver);
        actions.moveToElement(message.get(countMessage - 1));
        WebElement buttonDelete = driver.findElement(BUTTON_DELETE_MESSAGE);
        actions.click(buttonDelete).perform();
    }
    public void clickEditMessage(String text, int number){
        driver.findElements(COUNT_MESSAGES_IN_CHAT_WINDOW).get(number - 1).click();
        driver.findElement(BUTTON_EDIT_MESSAGE).click();
        driver.findElement(FIELD_EDIT_MESSAGE).clear();
        driver.findElement(FIELD_EDIT_MESSAGE).sendKeys(text);
        driver.findElement(FIELD_EDIT_MESSAGE).sendKeys(Keys.ENTER);
    }
    public void alertMessageValidation(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_THEN_MESSAGE_EMPTY));
        String resultAlert = driver.findElement(ALERT_THEN_MESSAGE_EMPTY).getText();
        assertEquals(resultAlert, "Message cannot be empty!", "Не верный текст сообщения в алерте");
    }
    public void validationUserName(String nameUser){
        wait.until(ExpectedConditions.visibilityOfElementLocated(USER_NAME_IN_CHAT_WINDOW));
        String newName = driver.findElement(USER_NAME_IN_CHAT_WINDOW).getText();
        assertEquals(newName, nameUser, "Не совпали имена после изменения в настройках");
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
