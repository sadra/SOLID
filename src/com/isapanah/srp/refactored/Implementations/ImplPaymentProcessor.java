package com.isapanah.srp.refactored.Implementations;

import com.isapanah.srp.refactored.Services.PaymentGateway;
import com.isapanah.srp.refactored.Utility.Exceptions.AvsMismatchException;
import com.isapanah.srp.refactored.Utility.Exceptions.OrderException;
import com.isapanah.srp.refactored.Interfaces.IPaymentProcessor;
import com.isapanah.srp.refactored.Model.PaymentDetails;

public class ImplPaymentProcessor implements IPaymentProcessor {

    @Override
    public void processCreditCard(PaymentDetails paymentDetails, float amount) throws Exception {
        PaymentGateway paymentGateway = new PaymentGateway();

        try
        {
            paymentGateway.credentials = "account credentials";
            paymentGateway.cardNumber = paymentDetails.getCreditCardNumber();
            paymentGateway.expiresMonth = paymentDetails.getExpiresMonth();
            paymentGateway.expiresYear = paymentDetails.getExpiresYear();
            paymentGateway.nameOnCard = paymentDetails.getCardholderName();
            paymentGateway.amountToCharge = amount;

            paymentGateway.Charge();
        }
        catch (AvsMismatchException ex)
        {
            throw new OrderException("The card gateway rejected the card based on the address provided.", ex);
        }
        catch (Exception ex)
        {
            throw new OrderException("There was a problem with your card.", ex);
        }
    }
}
