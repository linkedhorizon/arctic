package org.lyg.proxy.static_proxy;

/**
 * 聚合方式
 */
public class Car3 implements Moveable {
    private Car car;
    public Car3(Car car){
        this.car = car;
    }
    @Override
    public void move() {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车开始行驶...");
        car.move();
        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶...汽车行驶时间："+(endTime - starttime)+"毫秒！");

    }
}
