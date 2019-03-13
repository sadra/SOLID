package com.isapanah.ocp.refactored.Implementations;

import com.isapanah.ocp.refactored.Interfaces.IPriceRule;
import com.isapanah.ocp.refactored.OrderItem;

public class SpecialPrice4BuyGetOneFree implements IPriceRule
{
    @Override
    public boolean isMatch(OrderItem orderItem) {
        return orderItem.getSku().startsWith("B4GOF");
    }

    @Override
    public float calculatePrice(OrderItem orderItem) {
        float total = orderItem.getQuantity()*1;
        int setsOfFive = orderItem.getQuantity()/5;
        total -= setsOfFive*1;
        return total;
    }
}
