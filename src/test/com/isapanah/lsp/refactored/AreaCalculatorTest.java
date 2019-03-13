package com.isapanah.lsp.refactored;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class AreaCalculatorTest
{
    @Test
    public void CalculateSquareArea() {
        Square square = new Square(4);
        Assert.assertEquals(16, square.area(), 0);
    }

    @Test
    public void CalculateRectangleArea() {
        Rectangle rectangle = new Rectangle(4, 5);
        Assert.assertEquals(20, rectangle.area(), 0);
    }

    @Test
    public void CalculateTriangleArea() {
        Triangle rectangle = new Triangle(2, 5);
        Assert.assertEquals(5, rectangle.area(), 0);
    }

    @Test
    public void CalculateIsSubstitutableForArea()
    {
        List<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Square(3));
        shapes.add(new Rectangle(3, 4));
        shapes.add(new Triangle(3, 5));

        ArrayList<Double> areas = new ArrayList<Double>();
        for(Shape shape : shapes)
        {
            areas.add(shape.area());
        }

        Assert.assertEquals(areas.get(0), 9, 0);
        Assert.assertEquals(areas.get(1), 12, 0);
        Assert.assertEquals(areas.get(2), 7.5, 0);
    }
}