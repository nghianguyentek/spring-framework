package vn.kihon.spring.boot.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import vn.kihon.spring.boot.Message;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private String topic;
    private boolean isSync = true;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public KafkaProducer topic(String topic) {
        this.topic = topic;
        return this;
    }

    public KafkaProducer isSync(boolean isSync) {
        this.isSync = isSync;
        return this;
    }

    public void send(Message message) {
        CompletableFuture<SendResult<String, String>> result = kafkaTemplate.send(topic, message.getId(), message.toString());
        if (isSync) {
            try {
                logger.info(result.get().toString());
            } catch (CancellationException | ExecutionException | InterruptedException ex) {
                logger.error(topic + ":" + message.toString(), ex);
            }
        } else {
            result.whenComplete((r, ex) -> {
                if (ex != null) {
                    logger.error(topic + ":" + message.toString(), ex);
                } else {
                    logger.info(r.toString());
                }
            });
        }
    }
}
