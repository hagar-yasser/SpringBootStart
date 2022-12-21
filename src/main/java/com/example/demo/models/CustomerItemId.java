package com.example.demo.models;


import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class CustomerItemId implements Serializable {
    private Customer customer;

    private Item item;
    @ManyToOne
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    @ManyToOne
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
