package com.isapanah.srp.refactored;

import com.isapanah.srp.refactored.Model.Cart;
import com.isapanah.srp.refactored.Model.OnlineOrder;
import com.isapanah.srp.refactored.Model.PaymentDetails;

public class WebSite {

    public WebSite(Cart cart, PaymentDetails paymentDetails) throws Exception {
        new OnlineOrder(cart, paymentDetails).checkout();
    }

}
