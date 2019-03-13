package com.isapanah.ocp.refactored.Interfaces;

import com.isapanah.ocp.refactored.OrderItem;

public interface IPriceRule {
    boolean isMatch(OrderItem orderItem);
    float calculatePrice(OrderItem orderItem);
}
