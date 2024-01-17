package vn.kihon.spring.boot.consumer;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

class KafkaConsumerTest {
    @Test
    void testConsumer() throws InterruptedException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(KafkaConsumerConfig.class);
        ctx.getBean(KafkaConsumer.class);
        TimeUnit.SECONDS.sleep(5);
    }
}