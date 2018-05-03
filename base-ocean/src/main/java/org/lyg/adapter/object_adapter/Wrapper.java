package org.lyg.adapter.object_adapter;


/**
 * Created by Administrator on 2018/5/3 0003.
 */
public class Wrapper implements Targetable {
    private Source source;
    public Wrapper(Source source){
        super();
        this.source = source;
    }
    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method!");
    }
}
