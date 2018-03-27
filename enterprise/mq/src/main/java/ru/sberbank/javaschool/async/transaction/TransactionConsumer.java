package ru.sberbank.javaschool.async.transaction;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

public class TransactionConsumer {
    public static void main(String[] args) throws JMSException {
        try (ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            ConnectionFactory connectionFactory = applicationContext.getBean(ConnectionFactory.class);
            Queue queue = applicationContext.getBean(Queue.class);

            try (Connection connection = connectionFactory.createConnection();
                 Session session = connection.createSession(true, 0);
                 MessageConsumer consumer = session.createConsumer(queue)
            ) {
                connection.start();

                TextMessage message1 = (TextMessage) consumer.receive();
                System.out.println(message1.getText());

                // if (true) throw new RuntimeException();

                TextMessage message2 = (TextMessage) consumer.receive();
                System.out.println(message2.getText());

                session.commit();
            }
        }
    }
}
