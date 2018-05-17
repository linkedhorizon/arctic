package org.lyg.proxy.jdk_dynamic_proxy.extend;

/**
 * jdk动态代理实现的思路
 * 实现功能：通过Proxy的newProxyInstance返回代理对象
 * 1、声明一段源码（动态产生代理）
 * 2、编译源码（jdk compiler API），产生新的类（代理类）
 * 3、将这个类load到内存当中，产生一个新的对象（代理对象）
 * 4、return 代理对象
 */
public class README {
}
