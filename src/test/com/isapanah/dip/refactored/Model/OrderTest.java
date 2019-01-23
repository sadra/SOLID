package com.isapanah.dip.refactored.Model;

import com.isapanah.dip.refactored.Fakes.FakeNotificationService;
import com.isapanah.dip.refactored.Fakes.FakePaymentProcessor;
import com.isapanah.dip.refactored.Fakes.FakeReservationService;
import com.isapanah.dip.refactored.Implementations.NotificationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderTest
{
    private FakePaymentProcessor paymentProcessor = new FakePaymentProcessor();
    private FakeReservationService reservationService = new FakeReservationService();
    private FakeNotificationService notificationService = new FakeNotificationService();
    private Cart cart= new Cart();
    private PaymentDetails paymentDetails = new PaymentDetails();

    @Before
    public void setup()
    {
        paymentDetails.setPaymentMethod(PaymentDetails.PaymentMethod.CreditCard);
    }

    @Test
    public void sendTotalAmountToPaymentProcessor() throws Exception
    {
        cart.setTotalAmount(500);


        OnlineOrder order = new OnlineOrder(
                cart,
                paymentProcessor,
                paymentDetails,
                reservationService,
                notificationService
        );

        order.checkout();

        Assert.assertTrue(paymentProcessor.wasCalled);
        Assert.assertEquals(cart.getTotalAmount(), paymentProcessor.amountPassed, 0);
    }

    @Test
    public void notFailWhenSendingNotification() throws Exception
    {
        cart.setCustomerEmail("someone@somewhere.com" );

        OnlineOrder order = new OnlineOrder(
                cart,
                paymentProcessor,
                paymentDetails,
                reservationService,
                notificationService
        );

        order.checkout();

        Assert.assertTrue(notificationService.wasCalled);
    }

    @Test
    public void notFailWhenReservingInventory() throws Exception
    {
        OnlineOrder order = new OnlineOrder(
                cart,
                paymentProcessor,
                paymentDetails,
                reservationService,
                notificationService
        );

        order.checkout();

        Assert.assertTrue(reservationService.wasCalled);
    }
}