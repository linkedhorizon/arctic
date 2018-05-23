package org.lyg.traditional.syncronize;

/**
 * Created by Administrator on 2018/5/23 0023.
 */
public class TraditionalThreadSynchronized {
    public static void main(String[] args){
        TraditionalThreadSynchronized t = new TraditionalThreadSynchronized();
        t.init();
    }
    public void init(){
        Outputer outputer = new Outputer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output1("abcdefg--abcdefg--abcdefg");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outputer.output3("ABCDEFG--ABCDEFG--ABCDEFG");
                }
            }
        }).start();

    }
    private static class Outputer{
        public void output1(String name){
                synchronized (this){
                    for(int i = 0;i < name.length();i++){
                        System.out.print(name.charAt(i));
                    }
                    System.out.println();
                }
        }
        public synchronized void output2(String name){
            for(int i = 0;i < name.length();i++){
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
        public static synchronized void output3(String name){
            for(int i = 0;i < name.length();i++){
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }
}
