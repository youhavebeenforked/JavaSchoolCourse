package ru.sberbank.javaschool.async.topicexample;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;

public class PoisonPillConsumer {
    public static void main(String[] args) throws JMSException {
        try (ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class)) {
            ConnectionFactory connectionFactory = applicationContext.getBean(ConnectionFactory.class);
            Topic topic = applicationContext.getBean(Topic.class);

            try (Connection connection = connectionFactory.createConnection();
                 Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                 MessageConsumer consumer = session.createConsumer(topic)
            ) {
                connection.start();

                do {
                    Message message = consumer.receive();

                    System.out.println("Received message: " + message);

                    if (message.getBooleanProperty("stop")) {
                        break;
                    }
                } while (true);
            }
        }
    }
}
