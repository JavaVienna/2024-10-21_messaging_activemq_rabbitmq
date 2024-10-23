package io.viesure.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConsumerConfig {

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topic-exchange");
    }

    @Bean
    public Queue topicQueue1() {
        return new Queue("topic-queue-1");
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue("topic-queue-2");
    }

    @Bean
    public Binding bindingTopicQueue1(TopicExchange topicExchange, @Qualifier("topicQueue1") Queue topicQueue1) {
        return BindingBuilder.bind(topicQueue1).to(topicExchange).with("io.viesure.*.rabbitmq");
    }

    @Bean
    public Binding bindingTopicQueue2(TopicExchange topicExchange, @Qualifier("topicQueue2") Queue topicQueue2) {
        return BindingBuilder.bind(topicQueue2).to(topicExchange).with("io.#");
    }
}
