package com.isapanah.srp.refactored;

import com.isapanah.srp.refactored.Model.*;

import static com.isapanah.srp.refactored.Model.PaymentDetails.PaymentMethod.*;

public class RetailPointOfTheSale {

    public RetailPointOfTheSale(
            Cart cart,
            PaymentDetails paymentDetails,
            PaymentDetails.PaymentMethod paymentMethod
    ) throws Exception {

        Order order;

        if(paymentMethod == Cash){
            order = new PosCashOrder(cart);
        }else{
            order = new PosCreditOrder(cart, paymentDetails);
        }

        order.checkout();

    }

}

