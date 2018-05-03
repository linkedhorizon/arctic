package annotation;

/**
 * JDK自带的注解
 * @Override @Deprecated @Suppresswarning
 * 常见的第三方注解
 * spring @Autowire @Service @Repository
 * Mybatis @InserProvider @UpdateProvider @Options
 *
 * 注解的分类
 * 按照运行机制分：
 * 源码注解：注解只在源码中存在，编译成.class文件就不存在了
 * 编译时注解：注解在源码和.class文件中都存在，jdk自带的注解就是
 * 运行时注解：在运行阶段还起作用，甚至会影响运行逻辑的注解。
 * 按照来源分：
 * 来自jdk的注解
 * 来自第三方的注解
 * 我们自定义的注解
 *
 * 元注解：注解的注解
 * 自定义注解的语法要求
 * 参考Description注解
 *
 * 解析注解
 * 概念：通过反射获取类，函数或成员上的运行注解信息，从而实现动态控制程序运行的逻辑
 */
public class README {
}
