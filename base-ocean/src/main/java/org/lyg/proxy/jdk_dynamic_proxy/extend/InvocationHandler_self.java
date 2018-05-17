package org.lyg.proxy.jdk_dynamic_proxy.extend;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/5/5 0005.
 */
public interface InvocationHandler_self {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
