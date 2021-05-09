package com.dash95.learning.CamelActiveMQSrpringBoot.config;

import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.JmsTransactionManager;

import javax.jms.ConnectionFactory;

@Configuration
public class JMSConfig {

    @Bean
    public JmsTransactionManager jmsTransactionManager(final ConnectionFactory connectionFactory) {
        JmsTransactionManager jmsTransactionManager = new JmsTransactionManager();
        jmsTransactionManager.setConnectionFactory(connectionFactory);
        return jmsTransactionManager;
    }

    @Bean(name = "activemq")
    public JmsComponent jmsComponent(final ConnectionFactory connectionFactory, final JmsTransactionManager  jmsTransactionManager, @Value("${max.concurrent.consumers}") final int maxConcurrentConsumers) {
        JmsComponent jmsComponent = JmsComponent.jmsComponentTransacted(connectionFactory,  jmsTransactionManager);
        jmsComponent.setMaxConcurrentConsumers(maxConcurrentConsumers);
        return jmsComponent;
    }
}
