package com.isapanah.ocp.refactored.Implementations;

import com.isapanah.ocp.refactored.Interfaces.IPriceRule;
import com.isapanah.ocp.refactored.Interfaces.IPricingCalculator;
import com.isapanah.ocp.refactored.OrderItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PricingCalculator implements IPricingCalculator {
    private List<IPriceRule> pricingRules;

    public PricingCalculator() {
        this.pricingRules = new ArrayList<IPriceRule>();
        pricingRules.add(new EachPriceRule());
        pricingRules.add(new PerGramPriceRule());
        pricingRules.add(new SpecialPriceRule());
        pricingRules.add(new SpecialPrice4BuyGetOneFree());
    }

    @Override
    public float CalculatePrice(OrderItem orderItem) {
        float total = pricingRules.stream()
                .filter(rule -> rule.isMatch(orderItem))
                .findFirst()
                .get()
                .calculatePrice(orderItem);
        return total;
    }
}
