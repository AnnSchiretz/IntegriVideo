package steps;

import io.qameta.allure.Step;
import models.Card;
import org.openqa.selenium.WebDriver;
import pages.BillingPage;

public class BillingSteps {
    private BillingPage billing;

    public BillingSteps(WebDriver driver) {
        billing = new BillingPage(driver);
    }
    @Step("Billing page for adding card is open")
    public BillingSteps billingPageIsOpen(){
        billing
                .openPage();
        return this;
    }
    @Step("Create and filling out information card")
    public BillingSteps createNewCard(Card card,int count){
        billing
                .addNewCard()
                .fillingOutInformCard(card);
        billing.checkCountCardAfterCreateNewCard(count);
        return this;

    }
    @Step("Count card")
    public int countCard(){
        int count = billing.countCardBeforeAdding();
        return count;
    }
    @Step("make another card default")
    public void cardDefault(){
        billing.makeCardDefault();
    }

}
