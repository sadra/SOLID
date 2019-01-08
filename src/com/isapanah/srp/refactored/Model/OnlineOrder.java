package com.isapanah.srp.refactored.Model;

import com.isapanah.srp.refactored.Implementations.ImplNotificationService;
import com.isapanah.srp.refactored.Implementations.ImplPaymentProcessor;
import com.isapanah.srp.refactored.Implementations.ImplReservationService;
import com.isapanah.srp.refactored.Interfaces.INotificationService;
import com.isapanah.srp.refactored.Interfaces.IPaymentProcessor;
import com.isapanah.srp.refactored.Interfaces.IReservationService;

public class OnlineOrder extends Order{

    private INotificationService notificationService;
    private PaymentDetails paymentDetails;
    private IPaymentProcessor paymentProcessor;
    private IReservationService reservationService;

    public OnlineOrder(Cart cart, PaymentDetails paymentDetails) {
        super(cart);
        this.paymentDetails = paymentDetails;
        this.paymentProcessor = new ImplPaymentProcessor();
        this.reservationService = new ImplReservationService();
        this.notificationService = new ImplNotificationService();
    }

    @Override
    public void checkout() throws Exception {

        paymentProcessor.processCreditCard(paymentDetails, cart.getTotalAmount());

        reservationService.reserveInventory(cart.getItems());

        notificationService.notifyCustomerOrderCreated(cart);

    }
}
