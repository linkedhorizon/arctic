package org.lyg.singleton;

/**
 * Created by Administrator on 2018/4/29 0029.
 */

/**
 * 饿汉式
 */
public class Singleton {
    private Singleton(){}
    private static Singleton instance = new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
}
