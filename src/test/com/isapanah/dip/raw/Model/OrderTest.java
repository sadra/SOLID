package com.isapanah.dip.raw.Model;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest
{
    @Test
    public void withNoItemsNoNotificationNoCreditCard() throws Exception
    {
        Order order = new Order();

        Cart cart = new Cart();
        boolean shouldNotifyCustomer = false;

        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setPaymentMethod(PaymentDetails.PaymentMethod.Cash);

        order.checkout(cart, paymentDetails, shouldNotifyCustomer);
    }

    @Test
    public void NotFailWithNoItemsNotificationNoCreditCard() throws Exception
    {
        Order order = new Order();

        Cart cart = new Cart();
        cart.setCustomerEmail("someone@nowhere.com");
        boolean shouldNotifyCustomer = true;

        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setPaymentMethod(PaymentDetails.PaymentMethod.Cash);

        order.checkout(cart, paymentDetails, shouldNotifyCustomer);
    }
}