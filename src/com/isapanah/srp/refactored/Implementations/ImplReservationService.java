package com.isapanah.srp.refactored.Implementations;

import com.isapanah.srp.refactored.Model.Cart;
import com.isapanah.srp.refactored.Model.OrderItem;
import com.isapanah.srp.refactored.Services.InventorySystem;
import com.isapanah.srp.refactored.Utility.Exceptions.InsufficientInventoryException;
import com.isapanah.srp.refactored.Utility.Exceptions.orderException;
import com.isapanah.srp.refactored.Interfaces.IReservationService;

public class ImplReservationService implements IReservationService {

    @Override
    public void reserveInventory(Cart cart) throws Exception {
        for(OrderItem item : cart.getItems())
        {
            try
            {
                InventorySystem inventorySystem = new InventorySystem();
                inventorySystem.reserve(item.getSku(), item.getQuantity());
            }
            catch (InsufficientInventoryException ex)
            {
                throw new orderException("Insufficient inventory for item " + item.getSku(), ex);
            }
            catch (Exception ex)
            {
                throw new orderException("Problem reserving inventory", ex);
            }
        }
    }
}
