package org.lyg.traditional.timer;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2018/5/22 0022.
 */
public class TraditionalTimer {
    public static void main1(String[] args){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing!!!");
            }
        }, 10000,3000);//10秒后启动，以后每3秒钟运行一次
    }


    //先2秒执行一次，再4秒执行一次
    static int count = 0;
    class MyTimerTask extends TimerTask{

        @Override
        public void run() {
            System.out.println("boom!!!!");
            count = (count + 1)%2;
            new Timer().schedule(new MyTimerTask(),2000 + count*2000);

        }
    }
    public static void main(String[] args){
        TraditionalTimer traditionalTimer = new TraditionalTimer();
        new Timer().schedule(traditionalTimer.new MyTimerTask(),2000);
    }
}
