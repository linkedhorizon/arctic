package org.lyg.aboutThread;

/**
 * Created by Administrator on 2018/4/28 0028.
 */
public class App {
    public static void main(String[] args){
        Shop shop = new Shop();
        Thread p1 = new Thread(new Producer(shop));
        //Thread p2 = new Thread(new Producer(shop));
       // Thread p3 = new Thread(new Producer(shop));

        Thread c1 = new Thread(new Consumer(shop));
       // Thread c2 = new Thread(new Consumer(shop));
       // Thread c3 = new Thread(new Consumer(shop));
        p1.start();
      //  p2.start();
       // p3.start();

        c1.start();
       // c2.start();
       // c3.start();
    }
}
