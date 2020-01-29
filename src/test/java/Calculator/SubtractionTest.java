package Calculator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SubtractionTest {
    Calculator calc;
    double number;
    double number1;

    @BeforeMethod
    public void before() {
        calc = new Calculator();
        number = Math.random() * 100;
        number1 = Math.random() * 100;
    }

    @DataProvider
    public Object[][] dataForSubtractionNumbers() {
        return new Object[][]{
                {number, number1},
                {number, number1},
                {number, number1}
        };
    }

    @Test(dataProvider = "dataForSubtractionNumbers", priority = 5)
    public void subtractionNumbers(double num, double num1) {
        String result = String.valueOf(number - number1);
        System.out.println(calc.subtraction(number,number1));
        assertEquals(result,calc.subtraction(number,number1), "Не сошлись результаты вычислений");
    }
    @Test(priority = 0)
    public void subtractNegativeNumbers(){
        String result = String.valueOf(-number - -number1);
        System.out.println(calc.subtraction(-number, -number1));
        assertEquals(result,calc.subtraction(-number, -number1),"Не сошлись результаты вычислений");
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
