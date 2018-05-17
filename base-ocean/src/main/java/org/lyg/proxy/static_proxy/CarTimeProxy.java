package org.lyg.proxy.static_proxy;

/**
 * Created by Administrator on 2018/5/5 0005.
 */
public class CarTimeProxy implements Moveable{
    private Moveable m;
    public CarTimeProxy(Moveable m){
        this.m = m;
    }
    @Override
    public void move(){
        long starttime = System.currentTimeMillis();
        System.out.println("汽车开始行驶...");
        m.move();
        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶...汽车行驶时间："+(endTime - starttime)+"毫秒！");
    }
}
