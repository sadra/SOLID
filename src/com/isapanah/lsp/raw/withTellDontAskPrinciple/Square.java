package com.isapanah.lsp.raw.withTellDontAskPrinciple;

public class Square extends Shape
{
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int Area() {
        return side*side;
    }
}
