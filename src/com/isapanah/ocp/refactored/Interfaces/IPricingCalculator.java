package com.isapanah.ocp.refactored.Interfaces;

import com.isapanah.ocp.refactored.OrderItem;

public interface IPricingCalculator {
    float CalculatePrice(OrderItem orderItem);
}
