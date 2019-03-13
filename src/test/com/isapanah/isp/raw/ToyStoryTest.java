package com.isapanah.isp.raw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import jdk.jshell.spi.ExecutionControl.*;
import org.junit.rules.ExpectedException;

import javax.naming.NameNotFoundException;

import static org.junit.Assert.*;

public class ToyStoryTest
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    BuzzLightyear buzz = new BuzzLightyear();
    SheriffWoody woody = new SheriffWoody();
    SlinkyDog slinky = new SlinkyDog();

    @Test
    public void buildBuzz() {
        buzz.setPrice(250);
        buzz.setColor("white");
        buzz.speak();
        buzz.fly();
        buzz.move();
        Assert.assertEquals(buzz.toString(), "The white Buzz Lightyear toys's price is 250$");
    }

    @Test
    public void buildWoody() {
        woody.setPrice(235);
        woody.setColor("brown");
        woody.speak();
        woody.move();
        Assert.assertEquals(woody.toString(), "The brown Sheriff Woody toys's price is 235$");
    }

    @Test
    public void buildSlinky() {
        slinky.setPrice(175);
        slinky.setColor("yellow");
        slinky.move();
        Assert.assertEquals(slinky.toString(), "The yellow Slinky Dog toys's price is 175$");
    }

    @Test
    public void woodyFlyingException() throws NotImplementedException{
        thrown.expect(NotImplementedException.class);
        thrown.expectMessage("The toy can't fly!");
        woody.fly();
    }

    @Test
    public void slinkyFlyingException() throws NotImplementedException{
        thrown.expect(NotImplementedException.class);
        thrown.expectMessage("The toy can't fly!");
        slinky.fly();
    }

    @Test
    public void slinkySpeakingException() throws NotImplementedException{
        thrown.expect(NotImplementedException.class);
        thrown.expectMessage("The toy can't speak");
        slinky.speak();
    }
}