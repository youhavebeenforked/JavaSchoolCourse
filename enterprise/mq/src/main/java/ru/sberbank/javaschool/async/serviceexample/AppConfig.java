package ru.sberbank.javaschool.async.serviceexample;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.jms.ConnectionFactory;
import javax.jms.Topic;

@Configuration
@ComponentScan
class AppConfig {
    @Bean
    public ConnectionFactory jmsFactory() {
        return new ActiveMQConnectionFactory("tcp://localhost:61616");
    }

    @Bean
    public Topic destination() {
        return new ActiveMQTopic("TESTTOPIC");
    }
}
