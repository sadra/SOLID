package com.isapanah.dip.refactored.Interfaces;

import com.isapanah.dip.refactored.Model.Cart;

public interface INotification
{
    public void notifyCustomer(Cart cart) throws Exception;
}