package org.lyg.muti_thread_sharedata;

/**
 * @author :lyg
 * @time :2018/5/23 0023
 */

/**
 * 设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1
 */
public class MultiThreadShareData {
    public static void main(String[] args){
        final ShareData shareData = new ShareData();
        for(int i = 0;i < 2;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0;j < 100;j++){
                        shareData.increament();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0;j < 100;j++){
                        shareData.decreament();
                    }
                }
            }).start();
        }

    }
}
class ShareData{
    private int j = 10;
    public synchronized void increament(){
        j++;
        System.out.println("j++,j:"+j);
    }
    public synchronized void decreament(){
        j--;
        System.out.println("j--,j:"+j);
    }
}