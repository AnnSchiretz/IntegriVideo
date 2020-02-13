package tests;

import io.qameta.allure.Description;
import models.Card;
import models.User;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddNewPaymentCardTest extends SettingsForTests {
    @Test(description = "Add new payment card in system")
    @Description("Check adding card in system")
    public void createNewCard(){
        User user = new User("schirets54646@mailinator.com","12345678");
        Card card = cardInform();
        logInSteps.loginInSystem(user);
        billingSteps.billingPageIsOpen();
        int count = billingSteps.countCard();
        billingSteps.createNewCard(card, count);
    }
    private Card cardInform(){
        GregorianCalendar calendar = new GregorianCalendar();
        String numberCard = "4242 4242 4242 4242";
        String mothCard = "12";
        String yearCard = Integer.toString(calendar.get(Calendar.YEAR)) ;
        String nameCard = "Grzegorz Brzęczyszczykiewicz";
        return new Card(numberCard,mothCard,yearCard,nameCard);
    }
}
