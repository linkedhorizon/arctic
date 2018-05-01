package org.lyg.activemqbase;

import org.apache.activemq.ActiveMQConnectionFactory;


import javax.jms.*;

/**
 * Created by Administrator on 2018/4/29 0029.
 */
public class Producer {
    private static final String url = "tcp://127.0.0.1:61616";
    private static final String queueName = "queue-test";
    public static void main(String[] args) throws JMSException {
        //1、创建ConnectionFactory
        ConnectionFactory factory = new ActiveMQConnectionFactory(url);
        //2、创建Connection
        Connection connection = factory.createConnection();
        //3、启动Connection
        connection.start();
        //4、创建会话Session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5、创建一个目的地
        //Destination destination = session.createQueue(queueName);//队列模式
        Destination destination = session.createTopic(queueName);//主题模式
        //6、创建一个生产者
        MessageProducer producer = session.createProducer(destination);
        for(int i = 0;i<50;i++){
            //7.创建消息
            TextMessage textMessage = session.createTextMessage("satest"+i);
            producer.send(textMessage);
            System.out.println("发送消息："+textMessage.getText());
        }
        //9、关闭连接
        connection.close();
    }
}
