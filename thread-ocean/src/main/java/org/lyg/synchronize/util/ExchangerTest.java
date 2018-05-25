package org.lyg.synchronize.util;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author :lyg
 * @time :2018/5/25 0025
 */
public class ExchangerTest {
    public static void main(String[] args){
        ExecutorService threadPool = Executors.newCachedThreadPool();
        Exchanger<String> market = new Exchanger<String>();
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String owner = "rice";
                    System.out.println("I am a farmer,I want sell the rice and get money");
                    Thread.sleep((long)(Math.random()*10000));
                    String result = market.exchange(owner);
                    System.out.println("farmer: I have got "+result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String owner = "money";
                    System.out.println("I am a businessman,I want purchase some rice with money");
                    Thread.sleep((long)(Math.random()*10000));
                    String result = market.exchange(owner);
                    System.out.println("businessman: I have got "+result);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
