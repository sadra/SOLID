package com.isapanah.dip.refactored.Implementations;

import com.isapanah.dip.refactored.Interfaces.IPaymentProcess;
import com.isapanah.dip.refactored.Model.Cart;
import com.isapanah.dip.refactored.Model.PaymentDetails;
import com.isapanah.dip.refactored.Services.PaymentGateway;
import com.isapanah.dip.refactored.Utility.Exceptions.AvsMismatchException;
import com.isapanah.srp.refactored.Utility.Exceptions.OrderException;

public class PaymentProcessService implements IPaymentProcess
{
    @Override
    public void processPayment(
            PaymentDetails paymentDetails, Cart cart) throws Exception
    {
        PaymentGateway paymentGateway = new PaymentGateway();

        try
        {
            paymentGateway.credentials = "account credentials";
            paymentGateway.cardNumber = paymentDetails.getCreditCardNumber();
            paymentGateway.expiresMonth = paymentDetails.getExpiresMonth();
            paymentGateway.expiresYear = paymentDetails.getExpiresYear();
            paymentGateway.nameOnCard = paymentDetails.getCardholderName();
            paymentGateway.amountToCharge = cart.getTotalAmount();

            paymentGateway.Charge();
        }
        catch (AvsMismatchException ex)
        {
            throw new AvsMismatchException("The card gateway rejected the card based on the address provided.", ex);
        }
        catch (Exception ex)
        {
            throw new OrderException("There was a problem with your card.", ex);
        }
    }
}