package io.viesure.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RabbitMqProducer {

    private final AmqpTemplate amqpTemplate;

    public void sendToFanoutExchange(String message) {
        amqpTemplate.convertAndSend("fanout-exchange", "", message);  // Fanout exchange ignores routing key
        System.out.println("Sent to fanout exchange: " + message);
    }

    public void sendToTopicExchange(String message, String routingKey) {
        amqpTemplate.convertAndSend("topic-exchange", routingKey, message);
        System.out.println("Sent to topic exchange with key (" + routingKey + "): " + message);
    }
}
