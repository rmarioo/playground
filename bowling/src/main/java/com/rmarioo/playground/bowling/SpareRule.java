package com.rmarioo.playground.bowling;

import java.util.List;

public class SpareRule implements BowlingRule
{

  private final List<Integer> rolls;

  public SpareRule(List<Integer> rolls)
  {

    this.rolls = rolls;
  }

  public int score(int i)
  {
    return spareScore(i);
  }

  private int spareScore(int i)
  {
    return isSpare(i) ? spareBonus(i) : 0;
  }

  private Integer spareBonus(int index)
  {
    return rolls.get(index+2);
  }

  private boolean isSpare(int i)
  {
    return i < 19 && rolls.get(i) + rolls.get(i+1) == 10;
  }
}
