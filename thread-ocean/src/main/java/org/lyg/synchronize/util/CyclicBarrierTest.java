package org.lyg.synchronize.util;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author :lyg
 * @time :2018/5/25 0025
 */
public class CyclicBarrierTest {
    public static void main(String[] args){
        ExecutorService threadPool = Executors.newCachedThreadPool();
        CyclicBarrier cb = new CyclicBarrier(3);//3个线程同时到达，才能继续
        for(int i = 0;i < 9;i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println(Thread.currentThread().getName()+" is arriving address - 1,"+cb.getNumberWaiting()+" has arrived");
                        cb.await();
                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println(Thread.currentThread().getName()+" is arriving address - 2,"+cb.getNumberWaiting()+" has arrived");
                        cb.await();
                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println(Thread.currentThread().getName()+" is arriving address - 3,"+cb.getNumberWaiting()+" has arrived");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            });
        }
    }
}
