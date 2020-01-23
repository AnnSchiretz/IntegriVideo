package pages;

import models.Card;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    public int countCardBeforeAdding(){
        List<WebElement> cards = driver.findElements(COUNT_CARD_BEFORE_ADDING);
        return cards.size();

    }
    public void createNewPaymentCardAndCheckCreate(Card card, int countCard){
        BillingPage billing = new BillingPage(driver);
        billing.isPageOpened();
        addNewCard.click();
        wait.until(ExpectedConditions.elementToBeClickable(cardForm));
        cardNumber.sendKeys(card.getNumber());
        cardMonth.sendKeys(card.getMonth());
        cardYear.sendKeys(card.getYear());
        cardName.sendKeys(card.getNameLastName());
        wait.until(ExpectedConditions.elementToBeClickable(addCard)).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(COUNT_CARD_BEFORE_ADDING));
        List<WebElement> cards = driver.findElements(COUNT_CARD_BEFORE_ADDING);
        assertNotEquals(countCard, cards.size(), "не добавилась карта");

    }
    public void makeCardDefault(){
        List<WebElement> cards = driver.findElements(MAKE_DEFAULT_BUTTON);
        if(cards.size() == 1){
            wait.until(ExpectedConditions.elementToBeClickable(MAKE_DEFAULT_BUTTON)).click();
        } else {
            System.out.println(cards.size());
            wait.until(ExpectedConditions.elementToBeClickable(cards.get(cards.size() - 1))).click();
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(MAKE_DEFAULT_MESSAGE));
    }
}
