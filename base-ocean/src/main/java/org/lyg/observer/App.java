package org.lyg.observer;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
public class App {
    public static void main(String[] args){
        Observer obj1 = new Observer1();
        Observer obj2 = new Observer2();
        Subject subject = new MySubject();
        subject.add(obj1);
        subject.add(obj2);

        subject.operation();
    }
}
