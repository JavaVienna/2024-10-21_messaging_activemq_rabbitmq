package io.viesure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FanoutConsumerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FanoutConsumerServiceApplication.class, args);
    }
}