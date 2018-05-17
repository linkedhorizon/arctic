package org.lyg.proxy.jdk_dynamic_proxy.extend;

import org.junit.Test;
import org.lyg.proxy.jdk_dynamic_proxy.Car;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2018/5/5 0005.
 */
public class App {
    @Test
    public void test1() throws IOException {
        //编译
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //文件管理者
        StandardJavaFileManager fileManager =
                compiler.getStandardFileManager(null,null,null);
        //获取文件
        Iterable units = fileManager.getJavaFileObjects("E:\\idea\\arctic\\base-ocean\\src\\main\\java\\org\\lyg\\proxy\\jdk_dynamic_proxy\\Car.java");
        //编译任务
        CompilationTask task = compiler.getTask(null,fileManager,null,null,null,units);
        //进行编译
        task.call();
        fileManager.close();

    }
    @Test
    public void test2() throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class c = classLoader.loadClass("org\\lyg\\proxy\\jdk_dynamic_proxy\\Car");
        System.out.println(c.getName());

    }
    @Test
    public void test3(){
        Car car = new Car();
        Proxy_self.newProxyInstance(Car.class.getClassLoader(), Car.class.getInterfaces(), new InvocationHandler_self() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("dir");
                return null;
            }
        });
    }
}
