package io.viesure.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import java.util.List;

import static io.viesure.utils.Constants.TRUSTED_PACKAGE;

@Configuration
public class ProducerConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory =
                new ActiveMQConnectionFactory(brokerUrl);
        activeMQConnectionFactory.setTrustedPackages(List.of(TRUSTED_PACKAGE));
        return activeMQConnectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());

        jmsTemplate.setPubSubDomain(true);

        return jmsTemplate;
    }
}
