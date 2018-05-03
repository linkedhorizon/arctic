package org.lyg.observer;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
public class MySubject extends AbstractSubject {
    @Override
    public void operation() {
        System.out.println("update myself");
        notifyObservers();
    }
}
