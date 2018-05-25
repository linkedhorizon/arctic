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
    * org.lyg.thread.pool
    * 线程池的概念与Executors类的应用
        * 创建固定大小的线程池
        * 创建缓存线程池
        * 创建单一线程池（如何实现线程死掉后重新启动？）
    * 关闭线程池
        * shutdown与shutdownNow的比较
    * 用线程池启动定时器
        * 调用ScheduledExecutorService的schedule方法，返回的ScheduleFuture对象可以取消任务
        * 支持间隔重复任务的定时方式，不直接支持绝对定时方式，需要转换成相对时间方式
    * Future Callable
        * 实现线程回调：每个线程完成后，返回信息
        * Callable要采用ExecutorService的submit方法提交，返回的future对象可以取消任务
        * CompletionService用于提交一组Callable任务，其take方法返回已完成的一个Callable任务对应的Future对象
* Lock&Condition实现线程同步通信
    * 线程锁
    ```
    Lock lock = new ReentrantLock();//重入锁
    lock.lock();
    try{
    //#do something
    }finally{
        lock.unlock();
    }
    ```
    * 读写锁

    分为读锁和写锁，多个读锁不互斥，读锁与写锁互斥、写锁与写锁互斥，这是由jvm自己控制的。如果代码只读数据，可以
    很多人同时读，但不能同时写，那就上读锁；如果代码修改数据，只能有一个人再写，且不能同时读取，那就上写锁。
    org.lyg.read_and_write_lock

    instance：设计一个缓存系统

    * Condition 实现通信

    Condition的功能类似在传统技术中的Object的wait和notify的功能。在等待Condition时，允许发生虚假唤醒。
    实现条件阻塞
    org.lyg.condition
* 同步工具
    * Semaphore 实现信号灯

    Semaphore 可以维护当前访问自身的线程个数，并提供了同步机制。使用Semaphore可以控制同时访问资源的线程个数。
    例如，实现一个文件允许的并发访问数。
    单个信号量的Semaphore对象可以实现互斥锁的功能，可以由一个线程获得“锁”，再由另一个线程释放“锁”

    * CyclicBarrier

    表示大家（线程）彼此等待，大家集合好后才开始出发，分散活动后又指定地点集合碰面，这就好组团（指定人数）旅游

    * CountDownLatch

    犹如倒计时计数器，调用CountDownLatch对象的countDown方法就将计数器减1，当计数器达到0时，则所有等待者或单个等待者开始执行

    * Exchanger
    用于实现两个人之间的数据交换，每个人在完成一定的事务后想与对方蒋欢数据，第一个先拿到数据的人将一直等待第二个人拿到数据来时才能彼此交换数据

* 可阻塞的队列
    * 队列包含固定长度的队列和不固定长度的队列
    * ArrayBlockingQueue
        * 通过BlockingQueue类的帮助文档，其中有各方法的区别对比表格
        * 只有put方法和take方法才具有阻塞功能
* 同步集合类
    * 传统集合类在并发访问时存在问题
    * 传统方式下用Collections工具类提供的synchronizedCollection方法来获得同步集合。
    * Java 5中提供了如下一些同步集合类
        * 通过查看java.util.concurrent包下的介绍
        * ConcurrentHashMap
        * CopyOnWriteArrayList
        * CopyOnWriteArraySet
    * 传统方式下的Collection在迭代集合时，不允许对集合进行修改
        * 修改集合，会出现ConcurrentModificationException