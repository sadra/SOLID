package com.isapanah.srp.refactored.Interfaces;

import com.isapanah.srp.refactored.Model.Cart;

public interface INotificationService {
    public void notifyCustomerOrderCreated(Cart cart);
}
