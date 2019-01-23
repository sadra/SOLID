package com.isapanah.dip.refactored.Fakes;

import com.isapanah.dip.refactored.Interfaces.INotification;
import com.isapanah.dip.refactored.Model.Cart;

public class FakeNotificationService implements INotification
{
    public boolean wasCalled = false;

    @Override
    public void notifyCustomer(Cart cart)
    {
        wasCalled = true;
    }
}
