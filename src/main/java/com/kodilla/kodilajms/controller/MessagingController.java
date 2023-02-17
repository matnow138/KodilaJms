package com.kodilla.kodilajms.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kodilla.kodilajms.domain.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/messages")
public class MessagingController {

    @Autowired
    private JmsTemplate jmsTemplate;

    private ObjectMapper mapper = new ObjectMapper();

    @GetMapping(path="/process")
    public void processMessage(@RequestParam String message){
        jmsTemplate.convertAndSend("queue-test", message);
    }

    @PostMapping(path="/order")
    public void createOrder(@RequestBody OrderDto orderDto) throws JsonProcessingException {
        String json = mapper.writeValueAsString(orderDto);
        jmsTemplate.convertAndSend("order-queue",json);
    }
}
