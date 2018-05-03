package org.lyg.decorator;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is the original method !");
    }
}
