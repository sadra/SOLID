package com.isapanah.lsp.raw.withTellDontAskPrinciple;

public class Triangle extends Shape
{
    private int base;
    private int height;

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    public double Area() {
        return 0.5*base*height;
    }
}
