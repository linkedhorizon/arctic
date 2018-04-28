package org.lyg.aboutThread;

/**
 * Created by Administrator on 2018/4/28 0028.
 */
public class Consumer implements Runnable{
    private Shop shop;
    public Consumer(Shop shop){
        this.shop = shop;
    }
    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.shop.consume();
        }
    }
}
