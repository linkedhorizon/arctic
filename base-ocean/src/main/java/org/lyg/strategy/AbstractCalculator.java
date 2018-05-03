package org.lyg.strategy;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
public class AbstractCalculator {
    public int[] split(String exp,String opt){
        String[] array = exp.split(opt);
        int[] arrayInt = new int[2];
        arrayInt[0] = Integer.parseInt(array[0].trim());
        arrayInt[1] = Integer.parseInt(array[1].trim());
        return arrayInt;
    }
}
