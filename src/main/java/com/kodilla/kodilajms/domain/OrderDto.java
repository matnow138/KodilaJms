package com.kodilla.kodilajms.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Random;

public class OrderDto {
    private int orderId;
    @JsonProperty("item")
    private String item;
    @JsonProperty("quantity")
    private int quantity;

    private Random random = new Random();
    public OrderDto(String item, String quantity) {
        this.orderId = random.nextInt(100);
        this.item = item;
        this.quantity = Integer.parseInt(quantity);
    }

    public OrderDto(){
        this.orderId = random.nextInt(100);
    }


    public int getOrderId() {
        return orderId;
    }

    public String getItem() {
        return item;
    }
}
