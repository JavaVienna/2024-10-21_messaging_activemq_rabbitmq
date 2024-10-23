package io.viesure.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import static io.viesure.utils.Constants.TOPIC_NAME;

@Slf4j
@Component
@EnableJms
public class DurableListener {

    @JmsListener(destination = TOPIC_NAME, containerFactory = "durableFactory")
    public void receiveMessage(String message) {
        log.info("Durable Subscriber received: " + message);
    }
}
