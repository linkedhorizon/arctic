package org.lyg.proxy.jdk_dynamic_proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2018/5/5 0005.
 */
public class App {
    @Test
    public void test1(){
        Car car = new Car();
        Moveable m = (Moveable)Proxy.newProxyInstance(car.getClass().getClassLoader(),car.getClass().getInterfaces(),new TimeHandler(car));
        m.move();
    }
    @Test
    public void test2(){
        Car car = new Car();
        Moveable m = (Moveable)Proxy.newProxyInstance(car.getClass().getClassLoader(),car.getClass().getInterfaces(),new TimeHandler(car));
        Moveable m2 = (Moveable)Proxy.newProxyInstance(m.getClass().getClassLoader(),m.getClass().getInterfaces(),new LogHandler(m));
        m2.move();
    }
    @Test
    public void test3(){
        Car car = new Car();
        Moveable m = (Moveable)Proxy.newProxyInstance(car.getClass().getClassLoader(),car.getClass().getInterfaces(),new TimeHandler(car));
    }
}
