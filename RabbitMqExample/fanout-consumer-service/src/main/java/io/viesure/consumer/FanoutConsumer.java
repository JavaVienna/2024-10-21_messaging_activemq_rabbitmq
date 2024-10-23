package io.viesure.consumer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FanoutConsumer {

    @RabbitListener(queues = "#{fanoutQueue1.name}")
    public void receiveFanoutMessage1(String message) {
        log.info("Fanout Consumer 1 received: " + message);
    }

    @RabbitListener(queues = "#{fanoutQueue2.name}")
    public void receiveFanoutMessage2(String message) {
        log.info("Fanout Consumer 2 received: " + message);
    }
}
