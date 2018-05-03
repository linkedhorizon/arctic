package org.lyg.decorator;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
public class App {
    public static void main(String[] args){
        Decorator decorator = new Decorator(new Source());
        decorator.method();
    }
}
