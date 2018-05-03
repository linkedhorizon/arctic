package org.lyg.builder;

/**
 * Created by Administrator on 2018/5/3 0003.
 */

import org.lyg.factory.abstract_factory.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 建造者类
 */
public class Builder {
    private List<Sender> list = new ArrayList<Sender>();

    public List<Sender> getList() {
        return list;
    }

    public void setList(List<Sender> list) {
        this.list = list;
    }

    /**
     * 生产mailSender
     * @param count
     */
    public void produceMailSender(int count){
        for(int i = 0;i < count;i++){
            list.add(new MailSender());
        }
    }

    /**
     * 生产smsSender
     * @param count
     */
    public void produceSmsSender(int count){
        for(int i = 0;i < count;i++){
            list.add(new SmsSender());
        }
    }
}
