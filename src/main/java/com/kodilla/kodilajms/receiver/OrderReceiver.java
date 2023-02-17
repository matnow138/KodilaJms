package com.kodilla.kodilajms.receiver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kodilla.kodilajms.domain.OrderDto;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderReceiver {
    ObjectMapper mapper = new ObjectMapper();
    @JmsListener(containerFactory = "jmsFactory", destination = "order-queue")
    public void orderReceive(String json) throws JsonProcessingException {
        OrderDto orderDto = mapper.reader()
                        .forType(OrderDto.class).readValue(json);
        System.out.println(orderDto.getOrderId());
    }
}
