package com.isapanah.dip.refactored.Implementations;

import com.isapanah.dip.refactored.Interfaces.IReservation;
import com.isapanah.dip.refactored.Model.Cart;
import com.isapanah.dip.refactored.Model.OrderItem;
import com.isapanah.dip.refactored.Services.InventorySystem;
import com.isapanah.dip.refactored.Utility.Exceptions.InsufficientInventoryException;
import com.isapanah.dip.refactored.Utility.Exceptions.orderException;

public class ReservationService implements IReservation
{
    @Override
    public void reserveInventory(Cart cart) throws Exception
    {
        for(OrderItem item : cart.getItems())
        {
            try
            {
                InventorySystem inventorySystem = new InventorySystem();
                inventorySystem.reserve(item.getSku(), item.getQuantity());
            }
            catch (InsufficientInventoryException ex)
            {
                throw new InsufficientInventoryException("Insufficient inventory for item "+item.getSku(), ex);
            }
            catch (Exception ex)
            {
                throw new orderException("Problem reserving inventory", ex);
            }
        }
    }
}
