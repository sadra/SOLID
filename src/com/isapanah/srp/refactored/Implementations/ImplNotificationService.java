package com.isapanah.srp.refactored.Implementations;

import com.isapanah.srp.refactored.Utility.Logger;
import com.isapanah.srp.refactored.Interfaces.INotificationService;
import com.isapanah.srp.refactored.Model.Cart;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class ImplNotificationService implements INotificationService
{
    @Override
    public void notifyCustomerOrderCreated(Cart cart) {
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
                Logger.error("Problem sending notification email", ex);
            }
        }
    }
}
