package org.lyg.proxy.cglib_dynamic_proxy;

import org.junit.Test;

/**
 * Created by Administrator on 2018/5/5 0005.
 */
public class App {
    @Test
    public void test1(){
        CglibProxy cglibProxy = new CglibProxy();
        Train t = (Train)cglibProxy.getProxy(Train.class);
        t.move();
    }
}
