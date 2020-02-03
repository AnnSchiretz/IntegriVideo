package Calculator;

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
    @Test
    public void divisionOperation(){
        String result = String.valueOf(workNumber / secondWorkNumber);
        System.out.println(result);
        System.out.println(calc.division(workNumber, secondWorkNumber));
        assertEquals(result, calc.division(workNumber, secondWorkNumber),"Не сошлись результаты вычислений");
    }
    @Test
    public void divisionOperationWithZero(){
        double number = 0;
        String result = String.valueOf(workNumber / number);
        System.out.println(calc.division(workNumber, number));
        assertEquals(result,calc.division(workNumber, number),"Не сошлись результаты вычислений");
    }
    @Test
    public void divisionZeroOnTheZero(){
        double number = 0;
        String result = String.valueOf(number/ number);
        System.out.println(calc.division(number, number));
        assertEquals(result,calc.division(number, number),"Не сошлись результаты вычислений");
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
