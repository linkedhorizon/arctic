package org.lyg.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author :lyg
 * @time :2018/5/25 0025
 */
public class BlockingQueueTest {
    public static void main(String[] args){
        final BlockingQueue queue = new ArrayBlockingQueue<Character>(3);
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 0;i < 26;i++){
                            try {
                                System.out.println(Thread.currentThread().getName()+" ready to put data");
                                queue.put((char)(i+65));
                                System.out.println(Thread.currentThread().getName()+" put "+ (char)(i+65));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        ).start();

        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for(int i = 0;i < 26;i++){
                            try {
                                System.out.println(Thread.currentThread().getName()+" ready to take data");
                                Character data = (Character)queue.take();
                                System.out.println(Thread.currentThread().getName()+" take "+ data);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
        ).start();
    }
}
