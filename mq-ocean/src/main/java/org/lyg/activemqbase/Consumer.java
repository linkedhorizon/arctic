package org.lyg.activemqbase;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Administrator on 2018/4/29 0029.
 */
public class Consumer {
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
        MessageConsumer consumer = session.createConsumer(destination);
        //7、创建一个监听器
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("接收到消息："+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        //9、关闭连接,在退出时关闭，监听时候关闭导致无法收到消息
        //connection.close();
    }
}
