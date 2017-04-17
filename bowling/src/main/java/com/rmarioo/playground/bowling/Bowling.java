package com.rmarioo.playground.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

    int allSparesBonus =  IntStream.range(0,rolls.size())
             .map(i -> (i < 19 && rolls.get(i) + rolls.get(i+1) == 10) ? rolls.get(i+2) : 0)
             .sum();
    return sum + allSparesBonus;
  }

}
