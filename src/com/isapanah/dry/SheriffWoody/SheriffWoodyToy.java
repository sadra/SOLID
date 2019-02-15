package com.isapanah.dry.SheriffWoody;

public class SheriffWoodyToy implements Toy
{
    private int price;

    public SheriffWoodyToy(int price)
    {
        this.price = price;
    }

    @Override
    public void showPrice()
    {
        System.out.println(
                String.format("The price of this Sheriff Woody Toy is %d $!", this.price)
        );
    }
}
