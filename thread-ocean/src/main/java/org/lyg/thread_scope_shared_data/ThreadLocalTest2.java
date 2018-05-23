package org.lyg.thread_scope_shared_data;

        import java.util.Random;

/**
 * @author :lyg
 * @time :2018/5/23 0023
 */
public class ThreadLocalTest2 {
    private static ThreadLocal<Integer> localData = new ThreadLocal<Integer>();
    public static void main(String[] args){
        for(int i = 0;i < 2;i++){
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            int data = new Random().nextInt();
                            System.out.println(Thread.currentThread().getName()+" put data:"+data);
                            Admin admin = Admin.getInstance();
                            admin.setName("data:"+data);
                            admin.setAge(data);
                            new A().get();
                            new B().get();
                        }
                    }
            ).start();
        }

    }
    static class A{
        void get(){
            Admin admin = Admin.getInstance();
            System.out.println("A from "+Thread.currentThread().getName()+" get Admin:[name:"+admin.getName()+",age:"+admin.getAge()+"]");
        }
    }
    static class B{
        void get(){
            Admin admin = Admin.getInstance();
            System.out.println("B from "+Thread.currentThread().getName()+" get Admin:[name:"+admin.getName()+",age:"+admin.getAge()+"]");
        }
    }
}
class Admin{
    private Admin(){}
    public static Admin instance = null;
    public static ThreadLocal<Admin> adminThreadLocal = new ThreadLocal<Admin>();
    public static Admin getInstance(){
        instance = adminThreadLocal.get();
        if(instance == null){
            instance = new Admin();
            adminThreadLocal.set(instance);
        }
        return instance;
    }


    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
