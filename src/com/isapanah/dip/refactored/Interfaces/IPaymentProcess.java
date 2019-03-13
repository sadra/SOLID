package com.isapanah.dip.refactored.Interfaces;

import com.isapanah.dip.refactored.Model.Cart;
import com.isapanah.dip.refactored.Model.PaymentDetails;

public interface IPaymentProcess
{
    public void processPayment(PaymentDetails paymentDetails, Cart cart) throws Exception;
}
