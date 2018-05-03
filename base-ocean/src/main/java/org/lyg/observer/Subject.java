package org.lyg.observer;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
public interface Subject {
    /**
     * 添加观察者
     * @param observer
     */
    public void add(Observer observer);

    /**
     * 删除所有观察者
     * @param observer
     */
    public void del(Observer observer);

    /**
     * 通知所有观察者
     */
    public void notifyObservers();

    /**
     * 自身的操作
     */
    public void operation();
}
