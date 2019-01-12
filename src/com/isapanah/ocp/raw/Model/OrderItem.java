package com.isapanah.ocp.raw.Model;

public class OrderItem {

    private String sku;
    private int quantity;

    public OrderItem() {
    }

    public OrderItem(String sku, int quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public int getQuantity() {
        return quantity;
    }

}
