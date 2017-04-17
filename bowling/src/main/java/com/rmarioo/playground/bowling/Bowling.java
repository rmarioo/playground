package com.rmarioo.playground.bowling;

import java.util.ArrayList;
import java.util.List;

public class Bowling
{
  private List<Integer> rolls = new ArrayList();

  public void roll(int pins)
  {
    rolls.add(pins);
  }

  public int score()
  {
    int sum = rolls.stream().mapToInt(i -> i).sum();

    int spareBonus = 0;
    if ( rolls.get(0) + rolls.get(1) == 10)
    {
      spareBonus = rolls.get(2);
    }
    return sum + spareBonus;
  }

}
