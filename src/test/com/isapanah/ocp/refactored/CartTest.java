package com.isapanah.ocp.refactored;

import com.isapanah.ocp.refactored.Cart;
import com.isapanah.ocp.refactored.OrderItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

        System.out.println(cart.totalAmount());

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


    @Test
    public void SpecialItemBuy4GetOneFree() {
        cart.Add(new OrderItem("B4GOF_PENCIL", 5));
        Assert.assertTrue(4 == cart.totalAmount());
    }

}