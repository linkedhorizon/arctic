package org.lyg.adapter.class_adapter;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
public class Adapter extends Source implements Targetable {
    @Override
    public void method2() {
        System.out.println("this is the targetable method");
    }
}
