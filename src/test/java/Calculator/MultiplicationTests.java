package Calculator;

import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class MultiplicationTests {
    Calculator calc;
    double number;
    double number1;
    double workNumber;
    double secondWorkNumber;

    @BeforeMethod
    public void before() {
        calc = new Calculator();
        number = Math.random() * 100;
        workNumber = Math.round(number * 100d)/ 100d;
        number1 = Math.random() * 100;
        secondWorkNumber = Math.round(number1 * 100d)/ 100d;
    }
    @Test(description = "simple multiplication",threadPoolSize = 2, retryAnalyzer = Retry.class)
    @Description("simple multiplication")
    public void multiplication(){
        System.out.println(workNumber * secondWorkNumber);
        String validation = String.valueOf(workNumber * secondWorkNumber);
        System.out.println(validation);
        assertEquals(validation,calc.multiplication(workNumber,secondWorkNumber), "Не сошлись результаты");
    }
    @Test(description = "multiplication with zero",invocationCount = 5, threadPoolSize = 2)
    @Description("multiplication with zero")
    public void multiplicationWithZero(){
        double number = 0;
        String validation = String.valueOf(number * secondWorkNumber);
        System.out.println(calc.multiplication(number,secondWorkNumber));
        assertEquals(validation,calc.multiplication(number,secondWorkNumber), "Не сошлись результаты вычислений");
    }
    @AfterMethod
    public void afterMethod() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
