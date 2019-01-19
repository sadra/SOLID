package com.isapanah.isp.raw;

import jdk.jshell.spi.ExecutionControl.*;

public class SlinkyDog implements Toy
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
        System.out.println("Toy is walking.");
    }

    @Override
    public void fly() throws NotImplementedException{
        throw new NotImplementedException("The toy can't fly!");
    }

    @Override
    public void speak() throws NotImplementedException{
        throw new NotImplementedException("The toy can't speak!");
    }

    @Override
    public String toString() {
        return "The "+color+" Slinky Dog toys's price is "+price+"$";
    }
}
