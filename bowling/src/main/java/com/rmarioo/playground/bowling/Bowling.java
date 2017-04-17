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
    return rolls.stream().mapToInt(i->i).sum();
  }

}
