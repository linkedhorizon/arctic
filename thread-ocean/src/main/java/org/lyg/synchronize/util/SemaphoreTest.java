package org.lyg.synchronize.util;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author :lyg
 * @time :2018/5/25 0025
 */
public class SemaphoreTest {
    public static void main(String[] args){
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        Semaphore semaphore = new Semaphore(3);
        for(int i = 0;i < 10;i++){
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {

                            try {
                                semaphore.acquire();
                                System.out.println(Thread.currentThread().getName()+" has come in,concurrency now is "+(3 - semaphore.availablePermits()));
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName()+" is leaving ===");
                            semaphore.release();
                            System.out.println(Thread.currentThread().getName()+" has left,concurrency now is "+(3 - semaphore.availablePermits()));
                        }
                    }
            ).start();
        }
    }
}
