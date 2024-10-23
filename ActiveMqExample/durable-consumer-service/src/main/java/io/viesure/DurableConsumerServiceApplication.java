package io.viesure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DurableConsumerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DurableConsumerServiceApplication.class, args);
    }
}