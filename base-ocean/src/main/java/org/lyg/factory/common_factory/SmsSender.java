package org.lyg.factory.common_factory;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
public class SmsSender implements Sender{

    @Override
    public void send() {
        System.out.println("this is sms sender!!!");
    }
}
