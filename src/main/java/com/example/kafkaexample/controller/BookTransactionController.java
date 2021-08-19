package com.example.kafkaexample.controller;

import com.example.kafkaexample.model.BookTransaction;
import com.example.kafkaexample.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/book")
public class BookTransactionController {

    private final ProducerService producerService;

    @Autowired
    public BookTransactionController(ProducerService producerService){
        this.producerService = producerService;
    }

    @PostMapping(value = "/transaction")
    public void sendBookTransactionInfo(@RequestBody BookTransaction bookTransaction){
        this.producerService.sendTransactionInfo(bookTransaction);
    }
}
