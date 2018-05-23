package org.lyg.thread_scope_shared_data;

import java.util.HashMap;
import java.util.Random;

/**
 * @author :lyg
 * @time :2018/5/23 0023
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> localData = new ThreadLocal<Integer>();
    public static void main(String[] args){
        for(int i = 0;i < 2;i++){
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            int data = new Random().nextInt();
                            System.out.println(Thread.currentThread().getName()+" put data:"+data);
                            localData.set(data);
                            new A().get();
                            new B().get();
                        }
                    }
            ).start();
        }

    }
    static class A{
        void get(){
            int data = localData.get();
            System.out.println("A from "+Thread.currentThread().getName()+" get data:"+data);
        }
    }
    static class B{
        void get(){
            int data = localData.get();
            System.out.println("B from "+Thread.currentThread().getName()+" get data:"+data);
        }
    }
}
