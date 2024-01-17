package vn.kihon.spring.boot.consumer;

import org.springframework.kafka.annotation.KafkaListener;

public class KafkaConsumer {
    @KafkaListener(id = "listener1", topics = "topic2", groupId = "group")
    public void listen(String message) {
        System.out.println("Received " + message);
    }
}
