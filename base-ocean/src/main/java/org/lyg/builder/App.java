package org.lyg.builder;

/**
 * Created by Administrator on 2018/5/3 0003.
 */

import java.util.List;

/**
 * 建造者模式
 * 工厂类模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来进行管理，用来创建复合对象，所谓复合对象就是某个类具有不同的熟悉
 */
public class App {
    public static void main(String[] args){
        Builder builder = new Builder();
        builder.produceMailSender(4);
        builder.produceSmsSender(5);
        List<Sender> list = builder.getList();
        System.out.println(list.size());
        for(int i = 0;i < list.size();i++){
            Sender sender = list.get(i);
            sender.send();
        }
    }
}
