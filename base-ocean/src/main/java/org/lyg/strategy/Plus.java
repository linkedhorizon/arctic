package org.lyg.strategy;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
public class Plus extends AbstractCalculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int[] arrayInt = split(exp,"\\+");
        return arrayInt[0] + arrayInt[1];
    }
}
