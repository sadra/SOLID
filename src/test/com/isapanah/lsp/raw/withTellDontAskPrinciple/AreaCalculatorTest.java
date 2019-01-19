package com.isapanah.lsp.raw.withTellDontAskPrinciple;

import com.isapanah.lsp.raw.regular.AreaCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class AreaCalculatorTest
{
    @Test
    public void CalculateSquareArea() {
        Square square = new Square(4);
        Assert.assertEquals(16, square.Area());
    }

    @Test
    public void CalculateRectangleArea() {
        Rectangle rectangle = new Rectangle(4, 5);
        Assert.assertEquals(20, rectangle.Area());
    }


    @Test
    public void CalculateIsSubstitutableForArea() {

        List<Shape> shapes = new ArrayList<Shape>();

        shapes.add(new Square(3));
        shapes.add(new Rectangle(3, 4));
        shapes.add(new Triangle(3, 5));

        double[] areas = new double[3];

        for(Shape shape : shapes){
            if(shape instanceof Square){
                areas[0] = (((Square) shape).Area());
            }else if(shape instanceof Rectangle){
                areas[1] = (((Rectangle) shape).Area());
            }else if(shape instanceof Triangle){
                areas[2] = (((Triangle) shape).Area());
            }
        }

        Assert.assertEquals(areas[0], 9, 0);
        Assert.assertEquals(areas[1], 12, 0);
        Assert.assertEquals(areas[2], 7.5, 0);
    }
}