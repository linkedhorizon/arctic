package org.lyg.factory.common_factory;

/**
 * Created by Administrator on 2018/5/3 0003.
 */

/**
 * 普通静态工厂方法
 */
public class SenderFactory {
    public static Sender produce(String type){
        if(type.equals("mail")){
            return new MailSender();
        }else if(type.equals("sms")){
            return new SmsSender();
        }else {
            System.out.println("请输入正确的类型---");
        }
        return null;
    }
}
