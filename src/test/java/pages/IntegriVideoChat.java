package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    @Override
    public void openPage() {
    }

    @Override
    public void isPageOpened() {
    }

    @Step("Check text in message")
    public IntegriVideoChat messageShouldContainText(String message, int messageNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(MESSAGE_IN_WINDOW));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(MESSAGE_IN_WINDOW, messageNumber - 1));
        String text = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MESSAGE_IN_WINDOW)).get(messageNumber - 1).getText();
        assertEquals(message, text, "Message text is not correct");
        AllureUtils.takeScreenshot(driver);
        return this;
    }
    @Step("write message in chat input")
    public IntegriVideoChat setMessage(String message){
        wait.until(ExpectedConditions.elementToBeClickable(INPUT_MESSAGE)).click();
        driver.findElement(INPUT_MESSAGE).sendKeys(message);
        AllureUtils.takeScreenshot(driver);
        return this;
    }
    @Step("count message in chat window")
    public int getCountMessage(){
        int result = driver.findElements(GET_COUNT_MESSAGE).size();
        return result;
    }
    @Step("go to settings chat")
    public IntegriVideoChat goToSettingsModal(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(BUTTON_SETTINGS)).click();
        return this;
    }
    @Step("click upload file button")
    public void goToFileUpload(){
        driver.findElement(BUTTON_MANUAL_UPLOAD).click();
    }
    @Step("click send button")
    public IntegriVideoChat clickSendMessage(){
        driver.findElement(BUTTON_SEND_MESSAGE).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return this;
    }
    @Step("send message by Enter")
    public IntegriVideoChat sendMessageByEnter(){
        driver.findElement(BUTTON_SEND_MESSAGE).sendKeys(Keys.ENTER);
        return this;
    }
    @Step("click button for copy code")
    public String clickCopyCode(){
        String result =  driver.findElement(BUTTON_COPY_CODE).getText();
        driver.findElement(BUTTON_COPY_CODE).click();
        driver.findElement(MESSAGE_AFTER_COPY_MESSAGE).isDisplayed();
        AllureUtils.takeScreenshot(driver);
        return result;
    }
    @Step("copy invite link")
    public IntegriVideoChat clickInviteButton(){
        driver.findElement(BUTTON_INVITE).click();
        driver.findElement(ALERT_AFTER_CLICK_INVITE_BUTTON).isDisplayed();
        return this;
    }
    @Step("delete message in chat window")
    public IntegriVideoChat deleteMessage(int countMessage){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MESSAGE_IN_WINDOW));
        List<WebElement> message = driver.findElements(MESSAGE_IN_WINDOW);
        Actions actions = new Actions(driver);
        actions.moveToElement(message.get(countMessage - 1));
        WebElement buttonDelete = driver.findElement(BUTTON_DELETE_MESSAGE);
        actions.click(buttonDelete).perform();
        AllureUtils.takeScreenshot(driver);
        return this;
    }
    @Step("edit message in chat window")
    public IntegriVideoChat clickEditMessage(String text, int number){
        driver.findElements(COUNT_MESSAGES_IN_CHAT_WINDOW).get(number - 1).click();
        driver.findElement(BUTTON_EDIT_MESSAGE).click();
        driver.findElement(FIELD_EDIT_MESSAGE).clear();
        driver.findElement(FIELD_EDIT_MESSAGE).sendKeys(text);
        driver.findElement(FIELD_EDIT_MESSAGE).sendKeys(Keys.ENTER);
        return this;
    }
    @Step("check message in alert")
    public IntegriVideoChat alertMessageValidation(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_THEN_MESSAGE_EMPTY));
        String resultAlert = driver.findElement(ALERT_THEN_MESSAGE_EMPTY).getText();
        assertEquals(resultAlert, "Message cannot be empty!", "Не верный текст сообщения в алерте");
        AllureUtils.takeScreenshot(driver);
        return this;
    }
    @Step("check change user name")
    public IntegriVideoChat validationUserName(String nameUser){
        wait.until(ExpectedConditions.visibilityOfElementLocated(USER_NAME_IN_CHAT_WINDOW));
        String newName = driver.findElement(USER_NAME_IN_CHAT_WINDOW).getText();
        assertEquals(newName, nameUser, "Не совпали имена после изменения в настройках");
        AllureUtils.takeScreenshot(driver);
        return this;
    }
    @Step("skip trial version")
    public IntegriVideoChat skipTrialVersion(){
        driver.findElement(TRIAL_VERSION_MESSAGE);
        driver.findElement(TRIAL_VERSION_CLICK_SKIP).click();
        return this;
    }
    @Step("following a link in message")
    public IntegriVideoChat followingTheLinkInMessage(int numberTab, String locator){
        driver.findElement(LINK_IN_MESSAGE).click();
        moveToAnotherTabs(numberTab, locator);
        return this;
    }
    @Step("move around tabs in browser")
    public void moveToAnotherTabs(int numberTab, String locator){
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(numberTab));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
}
