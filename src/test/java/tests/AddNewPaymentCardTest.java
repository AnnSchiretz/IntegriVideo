package tests;

import models.Card;
import models.User;
import org.testng.annotations.Test;
import pages.BillingPage;
import pages.LogInPage;
import pages.ProjectPage;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddNewPaymentCardTest extends SettingsForTests {
    @Test
    public void createNewCard(){
        GregorianCalendar calendar = new GregorianCalendar();
        String numberCard = "4242 4242 4242 4242";
        String mothCard = "12";
        String yearCard = Integer.toString(calendar.get(Calendar.YEAR)) ;
        String nameCard = "Grzegorz Brzęczyszczykiewicz";
        Card card = new Card(numberCard,mothCard,yearCard,nameCard);

        logIn();
        BillingPage billing = new BillingPage(driver);
        billing.openPage();
        int countCard = billing.countCardBeforeAdding();
        billing.createNewPaymentCardAndCheckCreate(card, countCard);
    }
    private void logIn(){
        User user = new User("schirets54646@mailinator.com","12345678");
        LogInPage logIn = new LogInPage(driver);
        logIn.openPage();
        ProjectPage projectPage = logIn.logIn(user);
    }
}
