package com.isapanah.srp.refactored.Interfaces;

import com.isapanah.srp.refactored.Model.PaymentDetails;

public interface IPaymentProcessor {
    public void processCreditCard(PaymentDetails paymentDetails, float amount) throws Exception;
}
