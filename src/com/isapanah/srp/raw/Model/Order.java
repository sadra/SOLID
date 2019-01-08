package com.isapanah.srp.raw.Model;

import com.isapanah.srp.raw.Modules.MailMessage;
import com.isapanah.srp.raw.Modules.SmtpClient;
import com.isapanah.srp.raw.Services.InventorySystem;
import com.isapanah.srp.raw.Services.PaymentGateway;
import com.isapanah.srp.raw.Utility.exceptions.AvsMismatchException;
import com.isapanah.srp.raw.Utility.exceptions.InsufficientInventoryException;
import com.isapanah.srp.raw.Utility.Logger;
import com.isapanah.srp.raw.Utility.exceptions.OrderException;

import java.util.Date;

import static com.isapanah.srp.raw.Model.PaymentDetails.PaymentMethod.*;

public class Order {

    public void Checkout(Cart cart, PaymentDetails paymentDetails, boolean notifyCustomer) throws Exception
    {
        if (paymentDetails.getPaymentMethod() == CreditCard)
        {
            ChargeCard(paymentDetails, cart);
        }

        ReserveInventory(cart);

        if(notifyCustomer)
        {
            NotifyCustomer(cart);
        }
    }

    private void NotifyCustomer(Cart cart)
    {
        String customerEmail = cart.getCustomerEmail();
        if (!customerEmail.isEmpty())
        {
            MailMessage message = new MailMessage("orders@somewhere.com", customerEmail);
            SmtpClient client = new SmtpClient("localhost");
            {
                message.subject = "Your order placed on " + new Date().toString();
                message.body = "Your order details: \n " + cart.toString();

                try
                {
                    client.send(message);
                }
                catch (Exception ex)
                {
                    Logger.Error("Problem sending notification email", ex);
                }
            }
        }
    }

    private void ReserveInventory(Cart cart) throws Exception
    {
        for(OrderItem item : cart.getItems())
        {
            try
            {
                InventorySystem inventorySystem = new InventorySystem();
                inventorySystem.Reserve(item.getSku(), item.getQuantity());

            }
            catch (InsufficientInventoryException ex)
            {
                throw new OrderException("Insufficient inventory for item " + item.getSku(), ex);
            }
            catch (Exception ex)
            {
                throw new OrderException("Problem reserving inventory", ex);
            }
        }
    }

    private void ChargeCard(PaymentDetails paymentDetails, Cart cart) throws Exception
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
            throw new OrderException("The card gateway rejected the card based on the address provided.", ex);
        }
        catch (Exception ex)
        {
            throw new OrderException("There was a problem with your card.", ex);
        }

    }

}
