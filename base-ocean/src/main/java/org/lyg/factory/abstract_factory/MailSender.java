package org.lyg.factory.abstract_factory;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("this is mail sender!!!");
    }
}
