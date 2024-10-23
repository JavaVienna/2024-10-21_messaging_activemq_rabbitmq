package io.viesure.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static io.viesure.utils.Constants.FANOUT_EXCHANGE;

@Configuration
public class FanoutConsumerConfig {

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanout-queue-1");
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanout-queue-2");
    }

    @Bean
    public Binding bindingFanoutQueue1(FanoutExchange fanoutExchange, @Qualifier("fanoutQueue1") Queue fanoutQueue1) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    @Bean
    public Binding bindingFanoutQueue2(FanoutExchange fanoutExchange, @Qualifier("fanoutQueue2") Queue fanoutQueue2) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }
}
