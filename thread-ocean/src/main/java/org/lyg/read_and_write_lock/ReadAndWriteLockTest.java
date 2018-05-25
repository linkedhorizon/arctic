package org.lyg.read_and_write_lock;


import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author :lyg
 * @time :2018/5/25 0025
 */
public class ReadAndWriteLockTest {
    public static void main(String[] args){
        Queue3 queue = new Queue3();
        for(int i = 0;i < 2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    queue.get();
                }
            }).start();
        }
        for(int i = 0;i < 2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    queue.put();
                }
            }).start();
        }
    }
}
class Queue3{
    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    public void get(){
        rwl.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()+" is ready to read ---");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" has read data !!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rwl.readLock().unlock();
        }
    }
    public void put(){
        rwl.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" is ready to write ---");
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName()+" has write data !!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            rwl.writeLock().unlock();
        }
    }
}