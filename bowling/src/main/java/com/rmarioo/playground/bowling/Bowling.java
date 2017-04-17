package com.rmarioo.playground.bowling;

public class Bowling
{
  private Rolls rolls = new Rolls();

  public void roll(int pins)
  {
    rolls.add(pins);
  }

  public int score()
  {
    return rolls.sum();
  }

}
