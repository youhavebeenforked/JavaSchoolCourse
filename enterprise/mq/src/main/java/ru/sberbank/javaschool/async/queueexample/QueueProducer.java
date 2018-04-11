package ru.sberbank.javaschool.async.queueexample;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

public class QueueProducer {
    public static void main(String[] args) throws JMSException {
        try (ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            ConnectionFactory connectionFactory = applicationContext.getBean(ConnectionFactory.class);
            Queue queue = applicationContext.getBean(Queue.class);

            try (Connection connection = connectionFactory.createConnection();
                 Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                 MessageProducer producer = session.createProducer(queue)
            ) {
                // Смотрим аргументы метода createSession
                Message message = session.createTextMessage("My test message " + System.currentTimeMillis());
                producer.send(message);
            }
        }
    }
}
