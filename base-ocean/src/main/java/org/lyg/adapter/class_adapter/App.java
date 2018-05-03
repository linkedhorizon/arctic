package org.lyg.adapter.class_adapter;

/**
 * Created by Administrator on 2018/5/3 0003.
 */

/**
 * 类的适配器模式测试
 */
public class App {
    public static void main(String[] args){
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }
}
