package com.rmarioo.playground.bowling;

public class Bowling
{
  private int pins;

  public void roll(int pins)
  {

    this.pins +=pins;
  }

  public int score()
  {
    return pins;
  }
}
