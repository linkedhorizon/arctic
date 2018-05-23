package org.lyg.thread.pool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author :lyg
 * @time :2018/5/23 0023
 */
public class ThreadPool {
    /**
     * 创建固定大小的线程池
     */
    @Test
    public void test1(){
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        for(int i = 0;i < 10;i++){
            final int taskNum = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("task:"+ taskNum);
                }
            });
        }
    }
}
