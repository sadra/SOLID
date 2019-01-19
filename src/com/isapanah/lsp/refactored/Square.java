package com.isapanah.lsp.refactored;

public class Square extends Shape
{
    private int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side*side;
    }
}
