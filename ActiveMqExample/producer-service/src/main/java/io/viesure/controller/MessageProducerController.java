package io.viesure.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static io.viesure.utils.Constants.TOPIC_NAME;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MessageProducerController {

    private final JmsTemplate jmsTemplate;

    @PostMapping("/sendToTopic")
    public String sendMessageToTopic(@RequestParam("message") String message) {
        jmsTemplate.convertAndSend(TOPIC_NAME, message);
        log.info("Message sent to topic {} ", message);
        return "Message sent to topic: " + message;
    }
}