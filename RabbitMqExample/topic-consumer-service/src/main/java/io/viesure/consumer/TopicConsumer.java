package io.viesure.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TopicConsumer {

    @RabbitListener(queues = "#{topicQueue1.name}")
    public void receiveTopicMessage1(String message) {
        log.info("Topic Consumer 1 received: " + message);
    }

    @RabbitListener(queues = "#{topicQueue2.name}")
    public void receiveTopicMessage2(String message) {
        log.info("Topic Consumer 2 received: " + message);
    }
}
