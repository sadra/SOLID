package com.isapanah.dip.refactored.Services;

import com.isapanah.dip.refactored.Utility.Exceptions.InsufficientInventoryException;

public class InventorySystem {
    public void reserve(String sku, int quantity) throws InsufficientInventoryException
    {
        throw new InsufficientInventoryException("InventorySystem Not Implemented", null);
    }
}
