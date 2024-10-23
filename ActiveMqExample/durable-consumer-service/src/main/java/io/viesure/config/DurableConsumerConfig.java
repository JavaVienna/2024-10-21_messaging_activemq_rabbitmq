package io.viesure.config;


import jakarta.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import java.util.List;

import static io.viesure.utils.Constants.TRUSTED_PACKAGE;

@Configuration
public class DurableConsumerConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {

        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(brokerUrl);
        activeMQConnectionFactory.setTrustedPackages(List.of(TRUSTED_PACKAGE));
        return activeMQConnectionFactory;
    }

    @Bean
    public JmsListenerContainerFactory<?> durableFactory(@Qualifier("activeMQConnectionFactory") ConnectionFactory connectionFactory, DefaultJmsListenerContainerFactoryConfigurer configurer) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setClientId("durable-consumer-example");

        configurer.configure(factory, connectionFactory);

        factory.setSubscriptionDurable(true);
        // This decides will consumer be subsribed to topic or queue
        factory.setPubSubDomain(true);

        return factory;
    }
}
