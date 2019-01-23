package com.isapanah.dip.raw.Model;

import com.isapanah.dip.raw.Services.InventorySystem;
import com.isapanah.dip.raw.Services.PaymentGateway;
import com.isapanah.dip.raw.Utility.Exceptions.AvsMismatchException;
import com.isapanah.dip.raw.Utility.Exceptions.InsufficientInventoryException;
import com.isapanah.dip.raw.Utility.Exceptions.orderException;
import com.isapanah.dip.raw.Utility.Logger;

import java.util.Date;
import java.util.Properties;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import static com.isapanah.dip.raw.Model.PaymentDetails.PaymentMethod.CreditCard;


public class Order
{
    public void checkout(Cart cart, PaymentDetails paymentDetails, boolean notifyCustomer) throws Exception
    {
        if (paymentDetails.getPaymentMethod() == CreditCard)
        {
            processPayment(paymentDetails, cart);
        }

        reserveInventory(cart);

        if(notifyCustomer)
        {
            notifyCustomer(cart);
        }
    }

    private void notifyCustomer(Cart cart) throws Exception
    {
        String customerEmail = cart.getCustomerEmail();
        if (!customerEmail.isEmpty())
        {
            Properties properties = System.getProperties();
            properties.setProperty("mail.smtp.host", "localhost");
            Session session = Session.getDefaultInstance(properties);
            MimeMessage message = new MimeMessage(session);

            try
            {
                message.setFrom(new InternetAddress("mail@example.com"));
                message.addRecipient(
                        Message.RecipientType.TO,
                        new InternetAddress(customerEmail)
                );

                message.setSubject("Your order placed on " + new Date().toString());
                message.setText("Your order details: \n " + cart.toString());

                Transport.send(message);
                System.out.println("Message sent successfully.");
            }
            catch (Exception ex)
            {
                throw new Exception("Problem sending notification email"+ex);
            }
        }
    }

    private void reserveInventory(Cart cart) throws Exception
    {
        for(OrderItem item : cart.getItems())
        {
            try
            {
                InventorySystem inventorySystem = new InventorySystem();
                inventorySystem.reserve(item.getSku(), item.getQuantity());
            }
            catch (InsufficientInventoryException ex)
            {
                throw new orderException("Insufficient inventory for item "+item.getSku(),ex);
            }
            catch (Exception ex)
            {
                throw new orderException("Problem reserving inventory", ex);
            }
        }
    }

    private void processPayment(PaymentDetails paymentDetails, Cart cart) throws Exception
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
            throw new orderException("The card gateway rejected the card based on the address provided.", ex);
        }
        catch (Exception ex)
        {
            throw new orderException("There was a problem with your card.", ex);
        }
    }
}
