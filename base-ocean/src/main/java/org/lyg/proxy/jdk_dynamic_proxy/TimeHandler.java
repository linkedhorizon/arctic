package org.lyg.proxy.jdk_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/5/5 0005.
 */
public class TimeHandler implements InvocationHandler {
    public TimeHandler(Object target){
        super();
        this.target = target;
    }
    private Object target;
    /**
     *
     * @param proxy：被代理对象
     * @param method：被代理对象的方法
     * @param args：方法参数
     * @return 返回值：Object
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long starttime = System.currentTimeMillis();
        System.out.println("汽车开始行驶...");
        method.invoke(target);
        long endTime = System.currentTimeMillis();
        System.out.println("汽车结束行驶...汽车行驶时间："+(endTime - starttime)+"毫秒！");
        return null;
    }
}
