package org.lyg.proxy.jdk_dynamic_proxy;


import java.util.Random;

/**
 * Created by Administrator on 2018/5/5 0005.
 */
public class Car implements Moveable {
    @Override
    public void move() {

        try {
            Thread.sleep(new Random().nextInt(1000));
            System.out.println("汽车行驶中...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
