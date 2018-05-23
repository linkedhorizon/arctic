package org.lyg.traditional.syncronize.instance;

/**
 * 要求：子线程循环10次，接着主线程循环100次，接着又回到子线程循环10次，接着再回到主线程又循环100次
 * ，如此循环50次，请写出程序
 */
public class Instance {
    Instance instance = new Instance();
    public static void main(String[] args){
        Business business = new Business();
        //子线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < 50;i++){
                    business.sub(i);
                }
            }
        }).start();
        //主线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < 50;i++){
                    business.main(i);
                }
            }
        }).start();
    }

}
class Business{
    boolean sub_run = true;
    synchronized void sub(int count){
        while (!sub_run){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0;i < 10;i++){
            System.out.println("子线程第"+count+"轮，第"+i+"次循环");
        }
        sub_run = false;
        this.notify();
    }
    synchronized void main(int count){
        while (sub_run){//用while可以防止假唤醒，没有notify就自己唤醒了
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i = 0;i < 100;i++){
            System.out.println("主线程第"+count+"轮，第"+i+"次循环");
        }
        sub_run = true;
        this.notify();
    }
}