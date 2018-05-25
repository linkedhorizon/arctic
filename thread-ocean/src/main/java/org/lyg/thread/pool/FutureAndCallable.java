package org.lyg.thread.pool;


import java.util.concurrent.*;

/**
 * @author :lyg
 * @time :2018/5/25 0025
 */
public class FutureAndCallable {
    public static void main1(String[] args) throws Exception {
        ExecutorService threadpool = Executors.newFixedThreadPool(10);
        //Future取得的结果必须和Callable返回的结果一致
        Future future = threadpool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {//带返回结果的线程
                System.out.println("thread:"+Thread.currentThread().getName());
                return "线程已执行";
            }
        });
        System.out.println("等待结果--");
        // System.out.println("拿到结果："+future.get());
        System.out.println("1秒内拿到结果：" + future.get(1, TimeUnit.SECONDS));
    }
    //使用CompletionService用于提交一组Callable任务，其take方法返回已完成的一个Callable任务对应的Future对象
    public static void main(String[] args) throws Exception {
        ExecutorService threadpool = Executors.newFixedThreadPool(10);
        CompletionService completionService = new ExecutorCompletionService(threadpool);
        for(int i = 0;i < 10;i++){
            final int no = i;
            completionService.submit(new Callable() {
                @Override
                public String call() throws Exception {
                    System.out.println("current thread--" +Thread.currentThread().getName()+" is running!!! task-no:"+ no);
                    return Thread.currentThread().getName()+"has finished";
                }
            });
        }
        for(int i = 0;i < 10;i++){
            System.out.println(completionService.take().get());
        }

    }
}