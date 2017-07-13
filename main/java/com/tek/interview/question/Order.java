package com.tek.interview.question;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderDetails> orderDetails;

    public Order() {
        orderDetails=new ArrayList<>();
    }

    public void addOrderDetails(OrderDetails o) throws IllegalArgumentException {

        if (o == null) {
            System.err.println("ERROR - Order is NULL");
            throw new IllegalArgumentException("Order is NULL");
        }
        orderDetails.add(o);
    }

    public int getOrderSize() {
        return orderDetails.size();
    }

    public OrderDetails get(int i) {
        return orderDetails.get(i);
    }
  
}
