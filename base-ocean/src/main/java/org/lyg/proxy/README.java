package org.lyg.proxy;

/**
 * 静态代理：代理和被代理对象在代理之前是确定的。他们都实现的接口或者继承相同的抽象类
 * java动态代理类位于java.lang.reflect包下，一般主要涉及到一下两个类：
 * （1）Interface InvocationHandler：该接口中仅定义了一个方法
 * public Object invoke(Object obj,Method method,Object[] args)
 * 在实际使用时，第一个参数obj一般是代理类，method是被代理的方法，args
 * 为该方法的参数数组。这个抽象方法在代理类中动态实现。
 * （2）Proxy：该类即为动态代理类
 * static Object newProxyInstance(ClassLoader loader,Class[] interfaces,InvocationHandler h)：
 * 返回代理类的一个实例，返回后的代理类可以当作被代理类使用（可使用被代理类的在接口中声明过的方法）
 */
public class README {
}
