package com.isapanah.ocp.raw;

import com.isapanah.ocp.raw.Cart;
import com.isapanah.ocp.raw.OrderItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CartTest {

    private Cart cart;

    @Before
    public void Setup() throws Exception {
        cart = new Cart();
    }

    @Test
    public void ZeroWhenEmpty() {
        Assert.assertTrue(0 == cart.totalAmount());
    }

    @Test
    public void EachItem() {
        cart.Add(new OrderItem("EACH_WIDGET", 1));
        Assert.assertTrue(2 == cart.totalAmount());
    }

    @Test
    public void WeightItem() {
        cart.Add(new OrderItem("WEIGHT_PEANUTS", 500));
        Assert.assertTrue(3 == cart.totalAmount());
    }

    @Test
    public void SpecialItemRegular() {
        cart.Add(new OrderItem("SPECIAL_CANDYBAR", 6));
        Assert.assertTrue(2 == cart.totalAmount());
    }


    @Test
    public void SpecialItemFloat() {
        cart.Add(new OrderItem("SPECIAL_CANDYBAR", 2));
        Assert.assertTrue(0.8f == cart.totalAmount());
    }

}