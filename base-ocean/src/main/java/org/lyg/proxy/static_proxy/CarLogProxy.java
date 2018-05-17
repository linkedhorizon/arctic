package org.lyg.proxy.static_proxy;

/**
 * Created by Administrator on 2018/5/5 0005.
 */
public class CarLogProxy implements Moveable {
    private Moveable m;
    public CarLogProxy(Moveable m){
        this.m = m;
    }
    @Override
    public void move() {
        System.out.println("日志开始..." );
        m.move();
        System.out.println("日志结束...");
    }
}
