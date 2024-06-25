package com.edsoft.message_management_system.MMS.controller;

import com.edsoft.message_management_system.MMS.KafkaListeners;
import com.edsoft.message_management_system.MMS.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/messages")
public class MessageController {

    private KafkaListeners kafkaListeners;
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MessageController(KafkaListeners kafkaListeners, KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaListeners = kafkaListeners;
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void publish(@RequestBody Message message) {
        kafkaTemplate.send("event", message.text());
    }

    @GetMapping
    public List<String> getAllMessages() {
        return kafkaListeners.getMessages();
    }
}
