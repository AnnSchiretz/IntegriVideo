package Calculator;

import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class DivisionsTests {
    Calculator calc;
    double number;
    double number1;
    double workNumber;
    double secondWorkNumber;

    @BeforeMethod
    public void before() {
        calc = new Calculator();
        number = Math.random() * 10000;
        workNumber = Math.round(number * 10d)/ 10d;
        number1 = Math.random() * 10000;
        secondWorkNumber = Math.round(number1 * 10d)/ 10d;
    }
    @Test(description = "Simple division operation")
    @Description("division")
    public void divisionOperation(){
        String result = String.valueOf(workNumber / secondWorkNumber);
        System.out.println(result);
        System.out.println(calc.division(workNumber, secondWorkNumber));
        assertEquals("не сошлись результаты",result,calc.division(workNumber, secondWorkNumber));
    }
    @Test(description = "division operation with zero")
    @Description("division operation with zero")
    public void divisionOperationWithZero(){
        double number = 0;
        String result = String.valueOf(workNumber / number);
        System.out.println(calc.division(workNumber, number));
        assertEquals("Не сошлись результаты вычислений",result,calc.division(workNumber, number));
    }
    @Test(description = "division operation with zero")
    @Description("zero on the zero")
    public void divisionZeroOnTheZero(){
        double number = 0;
        String result = String.valueOf(number/ number);
        System.out.println(calc.division(number, number));
        assertEquals("Не сошлись результаты вычислений",result,calc.division(number, number));
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
