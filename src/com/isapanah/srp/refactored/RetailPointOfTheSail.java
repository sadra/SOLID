package com.isapanah.srp.refactored;

import com.isapanah.srp.refactored.Model.*;

import static com.isapanah.srp.refactored.Model.PaymentDetails.PaymentMethod.*;

public class RetailPointOfTheSail {

    public RetailPointOfTheSail(
            Cart cart,
            PaymentDetails paymentDetails,
            PaymentDetails.PaymentMethod paymentMethod)
            throws Exception {

        if(paymentMethod == Cash){
            PosCashOrder order = new PosCashOrder(cart);
            order.checkout();
        }else{
            PosCreditOrder order = new PosCreditOrder(cart, paymentDetails);
            order.checkout();
        }

    }

}
