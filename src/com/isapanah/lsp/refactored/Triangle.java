package com.isapanah.lsp.refactored;

public class Triangle extends Shape
{
    private int base;
    private int height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5*base*height;
    }
}
