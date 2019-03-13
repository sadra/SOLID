package com.isapanah.lsp.refactored;

public class Rectangle extends Shape
{
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width*height;
    }
}
