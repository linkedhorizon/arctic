package org.lyg.thread.pool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author :lyg
 * @time :2018/5/23 0023
 */
public class ThreadPool {
    /**
     * 创建固定大小的线程池
     */
    public static void main1(String[] args){
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        for(int i = 0;i < 10;i++){
            final int taskNum = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("current thread:"+Thread.currentThread().getName()+",task:"+ taskNum);
                }
            });
        }
        System.out.println("all of 10 task has committed!!!");
        threadPool.shutdownNow();//线程池中没有任何任务了，所有的线程都空闲下来，则清除线程池
        //threadPool.shutdownNow();//线程池中的线程用完，就清除线程池
    }

    /**
     * 创建缓存池
     * @param args
     */
    public static void main2(String[] args){//当内部线程不够时，自动增添新的线程
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for(int i = 0;i < 10;i++){
            final int taskNum = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("current thread:"+Thread.currentThread().getName()+",task:"+ taskNum);
                }
            });
        }

    }

    /**
     *
     * @param args
     */
    public static void main3(String[] args){//只有一个线程，这一个线程终止后，重新启动一个新的线程
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        for(int i = 0;i < 100;i++){
            final int taskNum = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("current thread:"+Thread.currentThread().getName()+",task:"+ taskNum);
                }
            });
        }
    }

    /**
     * 用线程池启动定时器，定时任务
     * @param args
     */
    public static void main4(String[] args){
        Executors.newScheduledThreadPool(3).schedule(new Runnable() {
                                                         @Override
                                                         public void run() {
                                                             System.out.println("boom!!!");
                                                         }
                                                     },
                10,
                TimeUnit.SECONDS);
    }
    /**
     * 以固定的频率启动任务
     * 缺陷：不能够直接指定具体的时间执行任务
     */
    public static void main(String[] args){
        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName()+":boom!!!");
                    }
                },
                10,
                2,  //10秒后，以2秒为频率启动任务
                TimeUnit.SECONDS);
    }
}
