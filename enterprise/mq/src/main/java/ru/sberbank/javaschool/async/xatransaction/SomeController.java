package ru.sberbank.javaschool.async.xatransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

@Controller
public class SomeController {
    private final UsersDao usersDao;

    private final ConnectionFactory jmsConnectionFactory;

    private final Topic userAddedtopic;

    @Autowired
    public SomeController(UsersDao usersDao, ConnectionFactory jmsConnectionFactory, Topic userAddedtopic) {
        this.usersDao = usersDao;
        this.jmsConnectionFactory = jmsConnectionFactory;
        this.userAddedtopic = userAddedtopic;
    }

    private void notifyUserAdded(User user) {
        try (Connection connection = jmsConnectionFactory.createConnection();
             Session session = connection.createSession(true, Session.SESSION_TRANSACTED);
             MessageProducer producer = session.createProducer(userAddedtopic)) {
            Message message = session.createTextMessage("User added" + user);
            producer.send(message);
        } catch (JMSException e) {
            throw new RuntimeException("Unable to notify listeners", e);
        }
    }

    @Transactional
    public void addUser(User user) {
        usersDao.create(user);
        notifyUserAdded(user);
        // throw new RuntimeException();
    }
}
