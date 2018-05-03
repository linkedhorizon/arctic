package org.lyg.factory.abstract_factory;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
public class App {
    public static void main(String[] args){
        Provider provider = new MailSenderFactory();
        Sender mailSender = provider.produce();
        mailSender.send();
    }
}
