package ru.sberbank.javaschool.async.queueexample;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

public class QueueConsumer {
    private static final Object LOCK = new Object();

    public static void main(String[] args) throws JMSException {
        try (ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            ConnectionFactory connectionFactory = applicationContext.getBean(ConnectionFactory.class);
            Queue queue = applicationContext.getBean(Queue.class);

            try (Connection connection = connectionFactory.createConnection();
                 Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                 // Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
                 MessageConsumer consumer = session.createConsumer(queue)
            ) {
                // Если мы читаем сообщения, то не забываем делать start у соединения
                connection.start();

                // Смотрим какие бывают receive
                TextMessage message = (TextMessage) consumer.receive();

//            consumer.setMessageListener(receivedMessage -> {
//                try {
//                    System.out.println("Message received: " + ((TextMessage) receivedMessage).getText());
//
//                    synchronized (LOCK) {
//                        LOCK.notifyAll();
//                    }
//                } catch (JMSException e) {
//                    e.printStackTrace();
//                }
//            });
//
//            synchronized (LOCK) {
//                try {
//                    System.out.println("Waiting for message");
//
//                    LOCK.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

                System.out.println(message.getText());

                // message.acknowledge();
            }
        }
    }
}
