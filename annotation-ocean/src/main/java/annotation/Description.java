package annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {//使用@interface关键自定义注解
    String desc();//成员以无参无异常方式声明
    String author();
    int age() default 18;//可以用default为成员指定一个默认值
}
/**
 * 1、 成员类型是受限的，合法的类型包括原始类型及String,Class,Annotation,Enumeration
 * 2、 如果注解还有一个成员，则成员名必须取名为value()，在使用时可以忽略成员名和赋值号（=）
 * 3、 注解类可以没有成员，没有成员的注解称为标识注解
 *
 * 元注解
 * Target：指定作用域范围
 * ElementType.METHOD：方法声明
 * ElementType.CONSTRUCTOR：构造方法声明
 * ElementType.FIELD：字段声明
 * ElementType.LOCAL_VARIABLE：局部变量声明
 * ElementType.PACKAGE：包声明
 * ElementType.PARAMETER：参数声明
 * ElementType.TYPE：类，接口
 *
 * Retention：生命周期
 * RetentionPolicy.RUNTIME：运行时存在，可以通过反射读取
 * RetentionPolicy.CLASS：编译时会记录到class中，运行时忽略
 * RetentionPolicy.SOURCE：只在源码显示，编译时会丢失
 *
 * Inherited：允许子类继承
 *
 * Documented：生成javadoc时会包含注解
 */