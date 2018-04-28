package org.lyg.aboutThread;

/**
 * Created by Administrator on 2018/4/28 0028.
 */
public class Shop {
    private int stock = 100;
    public synchronized void produce(){
        if(this.stock >= 100){
            notifyAll();
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.stock++;
        System.out.println(Thread.currentThread().getName()+"生产一个，库存：" + this.stock);
    }
    public synchronized void consume(){
        if(this.stock <= 0){
            notifyAll();
            try {
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.stock--;
        System.out.println(Thread.currentThread().getName()+"消费一个，库存：" + this.stock);
    }
}
