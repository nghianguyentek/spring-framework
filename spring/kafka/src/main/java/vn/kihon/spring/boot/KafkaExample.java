package vn.kihon.spring.boot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import vn.kihon.spring.boot.producer.KafkaProducer;
import vn.kihon.spring.boot.producer.KafkaProducerConfig;

public class KafkaExample {

    public static void main(String[] args) throws InterruptedException {
        testProducer();
    }

    private static void testProducer() throws InterruptedException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(KafkaProducerConfig.class);

        KafkaProducer kafkaProducer = ctx.getBean(KafkaProducer.class)
                .topic("topic2");

        for (int i = 0; i < 10; i++) {
            kafkaProducer.send(new Message().id("id1").name("name1"));
        }
    }
}
