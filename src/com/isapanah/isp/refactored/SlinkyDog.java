package com.isapanah.isp.refactored;

import com.isapanah.isp.refactored.Interfaces.Movable;
import jdk.jshell.spi.ExecutionControl.NotImplementedException;

public class SlinkyDog extends Toy implements Movable
{
    private int price;
    private String color;

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void move() {
        System.out.println("Slinky is walking.");
    }

    @Override
    public String toString() {
        return "The "+color+" Slinky Dog toys's price is "+price+"$";
    }
}
