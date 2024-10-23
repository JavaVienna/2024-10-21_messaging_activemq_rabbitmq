package io.viesure;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NonDurableConsumerServiceApplicationTest {

    @Autowired
    ApplicationContext context;

    @Test
    void contextStarts() {
        assertThat(context).isNotNull();
    }
}