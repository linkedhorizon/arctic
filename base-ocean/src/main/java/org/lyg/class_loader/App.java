package org.lyg.class_loader;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/5/6 0006.
 */
public class App {
    public static void main(String[] args) throws Exception {
        ClassLoader_self loader_self = new ClassLoader_self("E:/");
        Class c =loader_self.findClass("Car");
        Method method = c.getMethod("move");
        System.out.println(method.getName());
        method.invoke(c.newInstance());
    }
}
