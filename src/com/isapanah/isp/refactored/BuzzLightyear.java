package com.isapanah.isp.refactored;

import com.isapanah.isp.refactored.Interfaces.Flyable;
import com.isapanah.isp.refactored.Interfaces.Movable;
import com.isapanah.isp.refactored.Interfaces.Speakable;

public class BuzzLightyear extends Toy implements Movable, Flyable, Speakable
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
        System.out.println("Buzz is walking.");
    }

    @Override
    public void fly() {
        System.out.println("Buzz is flying.");
    }

    @Override
    public void speak() {
        System.out.println("Buzz is speaking.");
    }

    @Override
    public String toString() {
        return "The "+color+" Buzz Lightyear toys's price is "+price+"$";
    }
}
