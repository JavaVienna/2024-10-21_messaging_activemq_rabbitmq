package io.viesure.controller;

import io.viesure.producer.RabbitMqProducer;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {

    private final RabbitMqProducer rabbitMqProducer;

    @PostMapping("/sendToFanout")
    public String sendToFanout(@RequestParam("message") String message) {
        rabbitMqProducer.sendToFanoutExchange(message);
        return "Message sent to fanout exchange: " + message;
    }

    @PostMapping("/sendToTopic")
    public String sendToTopic(@RequestParam("message") String message, @RequestParam("routing_key") String routingKey) {
        rabbitMqProducer.sendToTopicExchange(message, routingKey);
        return "Message sent to topic exchange with routing key " + routingKey + ": " + message;
    }
}
