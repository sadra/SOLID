package com.isapanah.ocp.refactored.Implementations;

import com.isapanah.ocp.refactored.Interfaces.IPriceRule;
import com.isapanah.ocp.refactored.OrderItem;

public class EachPriceRule implements IPriceRule {
    @Override
    public boolean isMatch(OrderItem orderItem) {
        return orderItem.getSku().startsWith("EACH");
    }

    @Override
    public float calculatePrice(OrderItem orderItem) {
        return orderItem.getQuantity()*2;
    }
}
