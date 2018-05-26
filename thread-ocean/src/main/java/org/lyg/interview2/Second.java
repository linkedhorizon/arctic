package org.lyg.interview2;

/**
 * @author :lyg
 * @time :2018/5/26 0026
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Semaphore;

/**
 * 现程序中的Second类中的代码不断产生数据，然后交个TestDo.doSome()方法去处理，就好像生产者在不断地产生数据，
 * 消费者在不断消费数据。请将程序改造成由10个线程来消费生产者产生的数据，这些消费者都调用TestDo.doSome()方法
 * 去进行处理，故每个消费者都需要一秒才能处理完，程序应保证这些消费者线程一次有序地消费数据，只有上一个消费者
 * 消费完后，下一个消费者才能消费数据，下一个消费者谁都可以，但要保证这些消费者线程拿到的数据是有顺序的。
 */
public class Second {
    public static void main(String[] args){
        Semaphore semaphore = new Semaphore(1);
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
        for(int i = 0;i < 10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        String input = queue.take();
                        String output = TestDo.doSome(input);
                        System.out.println(Thread.currentThread().getName()+":"+output);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        System.out.println("begin:"+(System.currentTimeMillis()/1000));
        for(int i = 0;i < 10;i++){//这行不能改动
            String input = i + "";//这行不能改动
            try {
                queue.put(input);//!添加的
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //String output = TestDo.doSome(input);
           // System.out.println(Thread.currentThread().getName()+":"+output);
        }
    }
}
//不能改动此TestDo类
class TestDo{
    public static String doSome(String input){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String output = input + ":" + (System.currentTimeMillis()/1000);
        return output;
    }
}




/*
public class Second {
    public static void main(String[] args){
        System.out.println("begin:"+(System.currentTimeMillis()/1000));
        for(int i = 0;i < 10;i++){//这行不能改动
            String input = i + "";//这行不能改动
            String output = TestDo.doSome(input);
            System.out.println(Thread.currentThread().getName()+":"+output);
        }
    }
}

//不能改动此TestDo类
class TestDo{
    public static String doSome(String input){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String output = input + ":" + (System.currentTimeMillis()/1000);
        return output;
    }
}
*/