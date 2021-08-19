package com.example.kafkaexample.service;

import com.example.kafkaexample.model.BookTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    public static final String BOOK_TRANSACTION_TOPIC = "BookTransaction";

    private final KafkaTemplate<String, BookTransaction> kafkaTemplate;

    @Autowired
    public ProducerService(KafkaTemplate<String, BookTransaction> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTransactionInfo(BookTransaction bookTransaction){
        kafkaTemplate.send(BOOK_TRANSACTION_TOPIC, bookTransaction);
    }

}
