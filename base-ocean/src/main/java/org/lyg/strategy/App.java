package org.lyg.strategy;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
public class App {
    public static void main(String[] args){
        String exp = "9 - 55";
        ICalculator iCalculator = new Minus();
        int result = iCalculator.calculate(exp);
        System.out.println(result);
    }
}
