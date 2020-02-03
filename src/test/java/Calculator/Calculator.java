package Calculator;

public class Calculator {

    public String  sum (double ... num){
        double result = 0;
        for(double n: num)
            result += n;
        String sum = String.valueOf(result);
        return sum.replaceAll(",", ".");
    }

    public String  subtraction(double... num){
        double result = 0;
        for(double n: num)
            result =- result - n;
        String subtraction = String.valueOf(result);
        return subtraction;
    }

    public String division(double... num){
        double result = 0;
        for(int i = 0; i < num.length; i++){
            result += num[i];
            i++;
            result =+ result / num[i];
        }
        String res = String.valueOf(result);
        return res.replaceAll(",", ".");
    }

    public String multiplication(double... num){
        double result = 1;
        for(double n: num)
            result *= n;
        String res = String.valueOf(result);
        return res.replaceAll(",", ".");
    }
}
