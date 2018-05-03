package org.lyg.singleton;

/**
 * Created by Administrator on 2018/4/29 0029.
 */

/**
 * 懒汉式
 */
public class Singleton2 {
    private Singleton2(){}
    private static Singleton2 instance = null;
    public static synchronized Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
}
