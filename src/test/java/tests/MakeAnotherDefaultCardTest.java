package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.annotations.Test;

public class MakeAnotherDefaultCardTest extends SettingsForTests {
    @Test(description = "Make another card default")
    @Description("Check adding card in system")
    public void makeDefaultCard(){
        User user = new User("schirets54646@mailinator.com","12345678");
        logInSteps.loginInSystem(user);
        billingSteps.billingPageIsOpen()
                .cardDefault();
    }
}
