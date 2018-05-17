package org.lyg.proxy.jdk_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/5/5 0005.
 */
public class LogHandler implements InvocationHandler {
    public LogHandler(Object target){
        super();
        this.target = target;
    }
    private Object target;
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("日志开始..." );
        method.invoke(target);
        System.out.println("日志结束...");
        return null;
    }
}
