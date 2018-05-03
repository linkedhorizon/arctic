package org.lyg.observer;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
public class Observer1 implements Observer {
    @Override
    public void update() {
        System.out.println("observer1 has received!");
    }
}
