package com.edsoft.message_management_system.MMS;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KafkaListeners {
    private final List<String> messages = new ArrayList<>();
    @KafkaListener(topics = "event", groupId = "groupId")
    public void listener(String data) {
        System.out.println("Listener received : " + data);
        messages.add(data);
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }
}
