package pages;

import io.qameta.allure.Step;
import models.Card;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

import java.util.List;

import static org.testng.Assert.assertNotEquals;

public class BillingPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(), 'Add new')]")
    WebElement addNewCard;
    @FindBy (css = ".credit-card")
    WebElement cardForm;
    @FindBy (name = "number")
    WebElement cardNumber;
    @FindBy (name = "expirationMonth")
    WebElement cardMonth;
    @FindBy(name = "expirationYear")
    WebElement cardYear;
    @FindBy(name = "cardholderName")
    WebElement cardName;
    @FindBy(css = "form button")
    WebElement addCard;

    private static final By ADD_NEW_CARD = By.xpath("//a[contains(text(), 'Add new')]");
    private static final By COUNT_CARD_BEFORE_ADDING = By.cssSelector(".cards .row");
    private static final By MAKE_DEFAULT_BUTTON = By.xpath("//a[contains(text(), 'Make default')]");
    private static final By MAKE_DEFAULT_MESSAGE = By.xpath("//span[contains(text(), 'Default payment method successfully changed')]");

    public BillingPage(WebDriver driver) {
        super(driver);
    }

    public void openPage(){
        driver.get("https://dev.integrivideo.com/app/billing");
        isPageOpened();
        PageFactory.initElements(driver, BillingPage.this);
    }
    @Override
    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_NEW_CARD));
        } catch(TimeoutException ex) {
            throw new TimeoutException("Страница не загрузилась");
        }
    }
    @Step("Count before create new card")
    public int countCardBeforeAdding(){
        List<WebElement> cards = driver.findElements(COUNT_CARD_BEFORE_ADDING);
        return cards.size();
    }

    @Step("Add new card")
    public BillingPage addNewCard(){
        openPage();
        addNewCard.click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }
    @Step("Filling out information card")
    public BillingPage fillingOutInformCard(Card card){
        wait.until(ExpectedConditions.visibilityOf(addCard));
        cardNumber.sendKeys(card.getNumber());
        cardMonth.sendKeys(card.getMonth());
        cardYear.sendKeys(card.getYear());
        cardName.sendKeys(card.getNameLastName());
        wait.until(ExpectedConditions.elementToBeClickable(addCard)).click();
        AllureUtils.takeScreenshot(driver);
        return this;
    }
    @Step("Check count cards")
    public BillingPage checkCountCardAfterCreateNewCard(int countCard){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(COUNT_CARD_BEFORE_ADDING));
        List<WebElement> cards = driver.findElements(COUNT_CARD_BEFORE_ADDING);
        assertNotEquals(countCard, cards.size(), "не добавилась карта");
        return this;
    }
    @Step("Make another card default and check this")
    public BillingPage makeCardDefault(){
        AllureUtils.takeScreenshot(driver);
        List<WebElement> cards = driver.findElements(MAKE_DEFAULT_BUTTON);
        if(cards.size() == 1){
            wait.until(ExpectedConditions.elementToBeClickable(MAKE_DEFAULT_BUTTON)).click();
        } else {
            System.out.println(cards.size());
            wait.until(ExpectedConditions.elementToBeClickable(cards.get(cards.size() - 1))).click();
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(MAKE_DEFAULT_MESSAGE));
        AllureUtils.takeScreenshot(driver);
        return this;
    }
}
