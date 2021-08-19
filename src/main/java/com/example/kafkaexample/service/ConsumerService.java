package com.example.kafkaexample.service;

import com.example.kafkaexample.model.BookTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "BookTransaction", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    public void consume(BookTransaction bookTransaction){
        System.out.println("consumed: " + bookTransaction);
    }

}
