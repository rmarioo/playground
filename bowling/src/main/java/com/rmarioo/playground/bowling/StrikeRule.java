package com.rmarioo.playground.bowling;

import java.util.List;

public class StrikeRule implements BowlingRule
{
  private final List<Integer> pins;

  public StrikeRule(List<Integer> pins)
  {
    this.pins = pins;
  }

  @Override
  public int score(int i)
  {
    return isStrike(i) ? strikeBonus(i) : 0;
  }

  private int strikeBonus(int i)
  {
    return pins.get(i+1) + pins.get(i+2);
  }

  private boolean isStrike(int i)
  {
    return i < 19 && pins.get(i) == 10;
  }
}
