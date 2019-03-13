package com.isapanah.ocp.refactored;

import com.isapanah.ocp.refactored.Implementations.PricingCalculator;
import com.isapanah.ocp.refactored.Interfaces.IPricingCalculator;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<OrderItem> items;
    private IPricingCalculator pricingCalculator;

    public Cart()
    {
        pricingCalculator = new PricingCalculator();
        this.items = new ArrayList<OrderItem>();
    }

    public void Add(OrderItem orderItem)
    {
        items.add(orderItem);
    }

    public float totalAmount()
    {
        float total = 0;

        for(OrderItem orderItem : items)
        {
            total += pricingCalculator.CalculatePrice(orderItem);
        }

        return total;
    }

}
