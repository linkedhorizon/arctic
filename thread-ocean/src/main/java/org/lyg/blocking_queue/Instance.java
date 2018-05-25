package org.lyg.blocking_queue;

/**
 * @author :lyg
 * @time :2018/5/25 0025
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 使用阻塞队列，实现两个线程的交替进行
 */
public class Instance {
    public static void main(String[] args){
        Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < 10;i++){
                    business.sub1();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < 10;i++){
                    business.sub2();
                }
            }
        }).start();
    }
}
class Business{
    BlockingQueue<Integer> queue1 = new ArrayBlockingQueue<Integer>(1);
    BlockingQueue<Integer> queue2 = new ArrayBlockingQueue<Integer>(1);
    {
        try {
            queue2.put(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void sub1(){
        try {
            queue1.put(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("sub - 1 is running");

        try {
            queue2.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void sub2(){
        try {
            queue2.put(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("sub - 2 is running");

        try {
            queue1.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
