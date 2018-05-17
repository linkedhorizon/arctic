package org.lyg.proxy.static_proxy;

import org.junit.Test;

/**
 * Created by Administrator on 2018/5/5 0005.
 */
public class App {
    /**
     * 先记录日志，后记录时间
     */
    @Test
    public void test1(){
        Car car = new Car();
        CarTimeProxy ctp = new CarTimeProxy(car);
        CarLogProxy clp = new CarLogProxy(ctp);
        clp.move();
    }

    /**
     * 先记录时间，再记录日志
     */
    @Test
    public void test2(){
        Car car = new Car();
        CarLogProxy clp = new CarLogProxy(car);
        CarTimeProxy ctp = new CarTimeProxy(clp);
        ctp.move();
    }
}
