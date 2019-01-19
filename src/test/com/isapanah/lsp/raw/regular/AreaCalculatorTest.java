package com.isapanah.lsp.raw.regular;

import com.isapanah.lsp.raw.regular.AreaCalculator;
import com.isapanah.lsp.raw.regular.Rectangle;
import com.isapanah.lsp.raw.regular.Square;
import org.junit.Assert;
import org.junit.Test;

public class AreaCalculatorTest
{
    @Test
    public void CalculateSquareArea() {
        Square square = new Square();
        square.setWidth(2);
        Assert.assertEquals(4, AreaCalculator.CalculateArea(square));
    }

    @Test
    public void CalculateRectangleArea() {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(2);
        rectangle.setHeight(3);
        Assert.assertEquals(6, AreaCalculator.CalculateArea(rectangle));
    }


    @Test
    public void CalculateMixtureShapeArea() {
        Rectangle rectangle = new Square();
        rectangle.setWidth(4);
        rectangle.setHeight(5);
        Assert.assertEquals(20, AreaCalculator.CalculateArea(rectangle));
    }
}