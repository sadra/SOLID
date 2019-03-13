package com.isapanah.dip.refactored.Model;

import com.isapanah.dip.refactored.Interfaces.INotification;
import com.isapanah.dip.refactored.Interfaces.IPaymentProcess;
import com.isapanah.dip.refactored.Interfaces.IReservation;

public class OnlineOrder extends Order
{
    private PaymentDetails paymentDetails;
    private IReservation reservation;
    private IPaymentProcess paymentProcess;
    private INotification notifier;

    public OnlineOrder(
            Cart cart,
            IPaymentProcess paymentProcess,
            PaymentDetails paymentDetails,
            IReservation reservation,
            INotification notifier
    ) {
        super(cart);
        this.paymentProcess = paymentProcess;
        this.paymentDetails = paymentDetails;
        this.reservation = reservation;
        this.notifier = notifier;
    }

    @Override
    public void checkout() throws Exception
    {
        paymentProcess.processPayment(paymentDetails, cart);
        reservation.reserveInventory(cart);
        notifier.notifyCustomer(cart);
    }
}
