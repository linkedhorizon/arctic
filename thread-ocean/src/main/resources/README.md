# 传统线程技术
    Thread.currentThread() --> 获取当前线程
    Thread
    Runnable
# 传统定时器技术

    org.lyg.traditional.timer
    Timer类
    TimerTask类

# 传统线程同步互斥技术
    org.lyg.traditional.syncronize
    synchronized的用法
    静态方法、一般方法、代码块的锁对象

# ThreadLocal实现线程范围的共享变量
    org.lyg.thread_scope_shared_data
    ThreadLocal实现数据的独立存放

# 多个线程访问共享对象和数据的方式
    org.lyg.muti_thread_sharedata
    类似于生产消费问题

# Java5中的线程并发库
* java.util.concurrent.atomic 保证操作共享数据（运算）的原子性
    * AtomicInteger
    * AtomicBoolean
    * AtomicIntegerFieldUpdater
* 线程池
    * 线程池的概念与Executors类的应用
        * 创建固定大小的线程池
        * 创建缓存线程池
        * 创建单一线程池（如何实现线程死掉后重新启动？）
    * 关闭线程池
        * shutdown与shutdownNow的比较
    * 用线程池启动定时器
        * 调用ScheduledExecutorService的schedule方法，返回的ScheduleFuture对象可以取消任务
        * 支持间隔重复任务的定时方式，不直接支持绝对定时方式，需要转换成相对时间方式