package com.isapanah.dip.refactored.Fakes;

import com.isapanah.dip.refactored.Interfaces.IPaymentProcess;
import com.isapanah.dip.refactored.Model.Cart;
import com.isapanah.dip.refactored.Model.PaymentDetails;

public class FakePaymentProcessor implements IPaymentProcess
{
    public float amountPassed = 0;
    public boolean wasCalled = false;

    @Override
    public void processPayment(PaymentDetails paymentDetails, Cart cart)
    {
        wasCalled = true;
        amountPassed = cart.getTotalAmount();
    }
}
