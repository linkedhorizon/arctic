package org.lyg.factory.abstract_factory;

/**
 * Created by Administrator on 2018/5/3 0003.
 */
public class MailSenderFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
