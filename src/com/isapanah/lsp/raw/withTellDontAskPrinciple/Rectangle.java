package com.isapanah.lsp.raw.withTellDontAskPrinciple;

public class Rectangle extends Shape
{
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int Area() {
        return width*height;
    }
}
