package org.lyg.factory.more_factory;

/**
 * Created by Administrator on 2018/5/3 0003.
 */

/**
 * 多个工厂模式(静态工厂方法)
 */
public class SenderFactory {
   public static Sender produceMail(){
       return new MailSender();
   }
    public static Sender produceSms(){
        return new SmsSender();
    }
}
