package org.lyg.observer;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
public class Observer2 implements Observer{
    @Override
    public void update() {
        System.out.println("observer2 has received--");
    }
}
