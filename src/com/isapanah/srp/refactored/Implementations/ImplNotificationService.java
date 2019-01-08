package com.isapanah.srp.refactored.Implementations;

import com.isapanah.srp.refactored.Modules.SmtpClient;
import com.isapanah.srp.refactored.Modules.mailMessage;
import com.isapanah.srp.refactored.Utility.Logger;
import com.isapanah.srp.refactored.Interfaces.INotificationService;
import com.isapanah.srp.refactored.Model.Cart;

import java.util.Date;

public class ImplNotificationService implements INotificationService {

    @Override
    public void notifyCustomerOrderCreated(Cart cart) {
        String customerEmail = cart.getCustomerEmail();
        if (!customerEmail.isEmpty())
        {
            mailMessage message = new mailMessage("orders@somewhere.com", customerEmail);
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
                    Logger.error("Problem sending notification email", ex);
                }
            }
        }
    }
}
