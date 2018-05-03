package org.lyg.adapter.object_adapter;

/**
 * Created by Administrator on 2018/5/3 0003.
 */

/**
 * 对象适配器模式
 * 基本思路和类的适配器模式相同，
 * 只是将Adapter类做修改，这次不继承Source类，
 * 而是持久Source类的实例，以达到解决兼容性的问题
 */
public class App {
    public static void main(String[] args){
        Source source = new Source();
        Targetable target = new Wrapper(source);
        target.method1();
        target.method2();
    }
}
