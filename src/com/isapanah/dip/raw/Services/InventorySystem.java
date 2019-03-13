package com.isapanah.dip.raw.Services;

import com.isapanah.dip.raw.Utility.Exceptions.InsufficientInventoryException;

public class InventorySystem {
    public void reserve(String sku, int quantity) throws InsufficientInventoryException
    {
        throw new InsufficientInventoryException();
    }
}
