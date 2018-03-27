package ru.sberbank.javaschool.async.xatransaction;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.atomikos.jms.AtomikosConnectionFactoryBean;

import org.apache.activemq.ActiveMQXAConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.jms.ConnectionFactory;
import javax.jms.Topic;
import javax.jms.XAConnectionFactory;
import javax.sql.DataSource;
import javax.sql.XADataSource;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

@Configuration
@EnableTransactionManagement
@ComponentScan
class AppConfig {
    @Bean
    public XAConnectionFactory xaConnectionFactory() {
        return new ActiveMQXAConnectionFactory("tcp://localhost:61616");
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    public ConnectionFactory jmsConnectionFactory(XAConnectionFactory xaConnectionFactory) {
        AtomikosConnectionFactoryBean connectionFactoryBean = new AtomikosConnectionFactoryBean();
        connectionFactoryBean.setUniqueResourceName("xamq");
        connectionFactoryBean.setLocalTransactionMode(false);
        connectionFactoryBean.setXaConnectionFactory(xaConnectionFactory);
        return connectionFactoryBean;
    }

    @Bean
    public Topic destination() {
        return new ActiveMQTopic("TESTTOPIC");
    }

    @Bean
    public XADataSource xaDataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setUrl("jdbc:h2:~/test");
        dataSource.setUser("sa");
        dataSource.setPasswordChars(new char[]{});
        return dataSource;
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSource(XADataSource xaDataSource) {
        AtomikosDataSourceBean dataSourceBean = new AtomikosDataSourceBean();
        dataSourceBean.setUniqueResourceName("xads");
        dataSourceBean.setXaDataSource(xaDataSource);
        return dataSourceBean;
    }

    @Bean
    public UserTransaction userTransaction() throws SystemException {
        UserTransactionImp userTransactionImp = new UserTransactionImp();
        userTransactionImp.setTransactionTimeout(1000);
        return userTransactionImp;
    }

    @Bean(initMethod = "init", destroyMethod = "close")
    public TransactionManager transactionManager() {
        return new UserTransactionManager();
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(UserTransaction userTransaction, TransactionManager transactionManager) {
        return new JtaTransactionManager(userTransaction, transactionManager);
    }
}
