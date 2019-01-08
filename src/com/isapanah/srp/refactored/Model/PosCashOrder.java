package com.isapanah.srp.refactored.Model;

public class PosCashOrder extends Order {

    public PosCashOrder(Cart cart) {
        super(cart);
    }

    @Override
    public void checkout() throws Exception {
    }

}
