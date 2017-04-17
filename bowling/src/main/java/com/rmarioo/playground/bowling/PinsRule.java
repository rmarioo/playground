package com.rmarioo.playground.bowling;

import java.util.List;

class PinsRule implements BowlingRule
{
  private final List<Integer> rolls;

  public PinsRule(List<Integer> rolls)
  {
    this.rolls = rolls;
  }

  @Override
  public int score(int i)
  {
    return rolls.get(i);
  }
}
