package org.lyg.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :lyg
 * @time :2018/5/25 0025
 */
public class TreeConditionsTest {
    public static void main(String[] args){
        Business business = new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<5;i++){
                    business.sub1();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<5;i++){
                    business.sub2();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<5;i++){
                    business.sub3();
                }
            }
        }).start();
    }
}
class Business{
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    private int decide = 1;
    public void sub1(){
        lock.lock();
        try {
            while (decide != 1){
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("sub1 is running !!!");
            decide = 2;
            condition2.signal();
        }finally {
            lock.unlock();
        }
    }
    public void sub2(){
        lock.lock();
        try {
            while (decide != 2){
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("sub2 is running !!!");
            decide = 3;
            condition3.signal();
        }finally {
            lock.unlock();
        }
    }
    public void sub3(){
        lock.lock();
        try {
            while (decide != 3){
                try {
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("sub3 is running !!!");
            decide = 1;
            condition1.signal();
        }finally {
            lock.unlock();
        }
    }
}