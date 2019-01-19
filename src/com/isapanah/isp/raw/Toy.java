package com.isapanah.isp.raw;

import jdk.jshell.spi.ExecutionControl.*;

public interface Toy
{
    void setPrice(int price);
    void setColor(String color);
    void move() throws NotImplementedException;
    void fly() throws NotImplementedException;
    void speak() throws NotImplementedException;
}