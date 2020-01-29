package Calculator;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SumTest {
    Calculator calc;
    double number;
    double number1;

    @BeforeMethod
    public void before() {
        calc = new Calculator();
        number = Math.random() * 10000;
        number1 = Math.random() * 10000;
    }


    @Test
    public void checkSumThirdNumbers(){
        double numberThird = Math.random() * 1000;
        calc.sum(number, number1, numberThird);
        String res = String.valueOf(number+number1 + numberThird);
        assertEquals(res,calc.sum(number, number1, numberThird), "Не сошлись результаты вычислений");
    }
    @Test(invocationCount = 5)
    public void checkSumWithNegativeNumber(){
        double num = -665.9;
        String result = String.valueOf(num + number);
        assertEquals(result,calc.sum(number,num), "Не сошлись результаты вычислений");
    }
    @Test
    public void sumWithZero(){
        double num = 0;
        number = number * 100;
        int i = (int) Math.round(number);
        number = (double)i / 100;
        String res = String.valueOf(number);
        assertEquals(res.trim(),calc.sum(num,Double.parseDouble(res)), "Не сошлись результаты вычислений");
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
