package com.isapanah.srp.refactored.Interfaces;

import com.isapanah.srp.refactored.Model.Cart;
import com.isapanah.srp.refactored.Model.OrderItem;

public interface IReservationService {
    public void reserveInventory(Iterable<OrderItem> items) throws Exception;
}
