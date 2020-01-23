package tests;

import models.User;
import org.testng.annotations.Test;
import pages.BillingPage;
import pages.LogInPage;
import pages.ProjectPage;

public class MakeAnotherDefaultCardTest extends SettingsForTests {
    @Test
    public void makeDefaultCard(){
        logIn();
        BillingPage billing = new BillingPage(driver);
        billing.openPage();
        billing.makeCardDefault();

    }
    private void logIn(){
        User user = new User("schirets54646@mailinator.com","12345678");
        LogInPage logIn = new LogInPage(driver);
        logIn.openPage();
        ProjectPage projectPage = logIn.logIn(user);
    }
}
