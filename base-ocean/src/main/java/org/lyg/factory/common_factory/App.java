package org.lyg.factory.common_factory;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
public class App {
    public static void main(String[] args){
        Sender sender = SenderFactory.produce("sms");
        sender.send();
    }


}
