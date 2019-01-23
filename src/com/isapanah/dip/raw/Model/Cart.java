package com.isapanah.dip.raw.Model;

import java.util.ArrayList;

public class Cart
{
    private float totalAmount;
    private Iterable<OrderItem> items;
    private String customerEmail;

    public Cart()
    {
        this.items = new ArrayList<OrderItem>();
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Iterable<OrderItem> getItems() {
        return items;
    }

    public void setItems(Iterable<OrderItem> items) {
        this.items = items;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}