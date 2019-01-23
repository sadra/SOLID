package com.isapanah.dip.refactored.Fakes;

import com.isapanah.dip.refactored.Interfaces.IReservation;
import com.isapanah.dip.refactored.Model.Cart;

public class FakeReservationService implements IReservation
{
    public boolean wasCalled = false;

    @Override
    public void reserveInventory(Cart cart)
    {
        wasCalled = true;
    }
}
