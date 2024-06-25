package com.edsoft.message_management_system.MMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduledTasks {

    private final KafkaListeners kafkaListeners;

    @Autowired
    public ScheduledTasks(KafkaListeners kafkaListeners) {
        this.kafkaListeners = kafkaListeners;
    }

    @Scheduled(fixedRate = 1000) // 1000 milisaniye = 1 saniye
    public void getMessagesAtFixedRate() {
        List<String> messages = kafkaListeners.getMessages();
    }
}
