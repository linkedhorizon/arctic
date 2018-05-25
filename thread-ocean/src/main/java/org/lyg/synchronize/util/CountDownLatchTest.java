package org.lyg.synchronize.util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author :lyg
 * @time :2018/5/25 0025
 */
public class CountDownLatchTest {
    /**
     * 本例以田径，运动员等待裁判发令及都跑完项目后，运动员宣布比赛结束为背景
     * @param args
     */
    public static void main(String[] args){
        ExecutorService threadPool = Executors.newCachedThreadPool();
        CountDownLatch run_command = new CountDownLatch(1);//设置计数为1
        CountDownLatch stop_command = new CountDownLatch(3);//设置计数为3,及等3个运动员都跑完后宣布比赛结束
        for(int i = 0;i < 3;i++){
            threadPool.execute(new Runnable() {//运动员线程
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" is ready to run");
                    try {
                        run_command.await();
                        System.out.println(Thread.currentThread().getName()+" is running");
                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println(Thread.currentThread().getName()+"is going to finish match");
                        stop_command.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        //主线程，代表裁判员
        System.out.println("match is going to start, ready!");
        try {
            Thread.sleep(3000);
            run_command.countDown();
            stop_command.await();
            System.out.println("match has been completed,every athlete has arrived!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
