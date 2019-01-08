package com.isapanah.srp.refactored.Model;

import com.isapanah.srp.refactored.Implementations.ImplPaymentProcessor;
import com.isapanah.srp.refactored.Interfaces.IPaymentProcessor;

public class PosCreditOrder extends Order {

    private PaymentDetails paymentDetails;
    private IPaymentProcessor paymentProcessor;

    public PosCreditOrder(Cart cart, PaymentDetails paymentDetails) {
        super(cart);
        this.paymentDetails = paymentDetails;
        this.paymentProcessor = new ImplPaymentProcessor();
    }

    @Override
    public void checkout() throws Exception {
        paymentProcessor.processCreditCard(paymentDetails, cart.getTotalAmount());
    }
}
