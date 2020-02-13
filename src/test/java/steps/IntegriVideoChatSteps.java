package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.IntegriVideoChat;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class IntegriVideoChatSteps {
    private IntegriVideoChat chat;

    public IntegriVideoChatSteps(WebDriver driver){
        chat = new IntegriVideoChat(driver);
    }

    @Step("Send message by click button in chat window")
    public IntegriVideoChatSteps sendMessageAndEqualsText(String message, int count){
        chat.setMessage(message)
                .clickSendMessage();
        chat.messageShouldContainText(message, count);
        return this;
    }
    @Step("send message final and skip trial version in chat window ")
    public IntegriVideoChatSteps sendMessageAndSkipTrialVersion(String message){
        chat.setMessage(message)
                .clickSendMessage()
                .skipTrialVersion();
        return this;
    }
    @Step("send message")
    public IntegriVideoChatSteps sendMessage(String message){
        chat.setMessage(message)
                .clickSendMessage();
        return this;
    }
    @Step("validation text message in chat window")
    public IntegriVideoChatSteps validationMessage(String message, int count){
        chat.messageShouldContainText(message, count);
        return this;
    }
    @Step("go to link in message")
    public IntegriVideoChatSteps goToLinkAndMoveToThisTab(int numTab, String locator){
        chat.followingTheLinkInMessage(numTab,locator);
        return this;
    }

    @Step("count message")
    public int getCountMessage() {
        return chat.getCountMessage();
    }
    @Step("Send message click by Enter")
    public IntegriVideoChatSteps sendMessageByEnterAndValidationText(String message, int count){
        chat.setMessage(message)
                .sendMessageByEnter()
                .messageShouldContainText(message, count);
        return this;
    }
    @Step("edit sending message in chat window with validation")
    public IntegriVideoChatSteps editMessageWithValidation(String text, int count){
        chat.clickEditMessage(text, count);
        return this;
    }
    @Step("go to settings in chat")
    public void goToSettingsChat(){
        chat.goToSettingsModal();
    }
    @Step("go to upload file")
    public void goToFileUpload(){
        chat.goToFileUpload();
    }
    @Step("alert message for empty message")
    public IntegriVideoChatSteps checkAlertMessage(){
        chat.alertMessageValidation();
        return this;
    }
    @Step("Check new user name after change")
    public IntegriVideoChatSteps checkUserName(String userName){
        chat.validationUserName(userName);
        return this;
    }
    @Step("click copy code and validation this")
    public IntegriVideoChatSteps copyCodeAndValidate() throws IOException, UnsupportedFlavorException {
        String code = chat.clickCopyCode();
        String copyRefactorText = code.replaceAll("\n", "");
        String textInBuffer = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        assertEquals(copyRefactorText, textInBuffer, "Не совпала информация с DOM и в буфере обмена");
        return this;
    }
    @Step("click invitation button for copy link")
    public IntegriVideoChatSteps copyInvitationLink(){
        chat.clickInviteButton();
        return this;
    }
    @Step("delete message in chat window")
    public IntegriVideoChatSteps deleteMessage(int count){
        chat.deleteMessage(count);
        return this;
    }
}
