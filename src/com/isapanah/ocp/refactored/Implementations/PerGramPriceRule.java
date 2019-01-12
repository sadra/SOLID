package com.isapanah.ocp.refactored.Implementations;

import com.isapanah.ocp.refactored.Interfaces.IPriceRule;
import com.isapanah.ocp.refactored.OrderItem;

public class PerGramPriceRule implements IPriceRule
{
    @Override
    public boolean isMatch(OrderItem orderItem) {
        return orderItem.getSku().startsWith("WEIGHT");
    }

    @Override
    public float calculatePrice(OrderItem orderItem) {
        return orderItem.getQuantity()*6/1000;
    }
}
