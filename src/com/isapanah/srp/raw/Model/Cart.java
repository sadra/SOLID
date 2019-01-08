package com.isapanah.srp.raw.Model;

public class Cart {
    private float totalAmount;
    private Iterable<OrderItem> items;
    private String customerEmail;

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

class OrderItem
{
    private String sku;
    private int quantity;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}