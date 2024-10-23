package io.viesure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NonDurableConsumerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NonDurableConsumerServiceApplication.class, args);
    }
}