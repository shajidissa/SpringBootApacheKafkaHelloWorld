package uk.co.h2ss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import uk.co.h2ss.storage.MessageStorage;


@Component
public class KafkaConsumer {

    @Autowired
    MessageStorage storage;

    @KafkaListener(topics="test")
    public void processMessage(String content) {
        storage.put(content);
    }
}
