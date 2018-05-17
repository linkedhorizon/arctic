package org.lyg.proxy.jdk_dynamic_proxy;

/**
 * 动态代理实现步骤
 * 1、创建一个实现接口InvocationHandler的类，它必须实现invoke方法
 * 2、穿件被代理的类以及接口
 * 3、调用Proxy的静态方法，创建一个代理类
 * newProxyInstance(ClassLoader loader,Class[] interfaces,InvocationHandler h)
 * 4、通过代理调用方法
 *
 * jdk动态代理
 * 1、只能代理实现了接口的类
 * 2、没有实现接口的类不能实现JDK的动态代理
 *
 */
public class README {
}
