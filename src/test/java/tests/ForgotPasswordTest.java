package tests;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.LogInPage;

import java.util.ArrayList;

public class ForgotPasswordTest extends SettingsForTests {
    @Test
    public void forgotPassword(){
        User user = new User("schirets54646@mailinator.com","12345678");
        LogInPage logIn = new LogInPage(driver);
        logIn.openPage();
        logIn.goToForgotPassword(user);
        goToEmailBox();
    }
    private void goToEmailBox(){
        String link = "https://www.mailinator.com/v3/#/#inboxpane";
        String nameEmail = "schirets54646";
        String newPassword = "12345678";
        ((JavascriptExecutor) driver).executeScript("window.open();");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get(link);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//img[@alt='Mailinator Logo - Empty Inbox']")));
        WebElement inputInEmailBox = driver.findElement(By.id("inbox_field"));
        wait.until(ExpectedConditions.elementToBeClickable(inputInEmailBox)).click();
        inputInEmailBox.sendKeys(nameEmail);
        driver.findElement(By.id("go_inbox")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@ng-repeat='email in emails']//td[contains(text(), 'IntegriVideo')]"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".container"))));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name("msg_body")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='content']//a"))).click();
        ArrayList<String> tabsAfterLetter = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabsAfterLetter.get(2));
        driver.findElement(By.name("password")).sendKeys(newPassword);
        driver.findElement(By.name("password_approve")).sendKeys(newPassword);
        driver.findElement(By.xpath("//button")).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[contains(text(), 'Log in')]")));
    }
}
