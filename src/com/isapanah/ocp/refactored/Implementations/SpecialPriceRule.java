package com.isapanah.ocp.refactored.Implementations;

import com.isapanah.ocp.refactored.Interfaces.IPriceRule;
import com.isapanah.ocp.refactored.OrderItem;

public class SpecialPriceRule implements IPriceRule
{
    @Override
    public boolean isMatch(OrderItem orderItem) {
        return orderItem.getSku().startsWith("SPECIAL");
    }

    @Override
    public float calculatePrice(OrderItem orderItem) {
        float total = orderItem.getQuantity()*.4f;
        int setsOfThree = orderItem.getQuantity()/3;
        total -= setsOfThree*.2f;
        return total;
    }
}
