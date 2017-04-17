package com.rmarioo.playground.bowling;

import java.util.ArrayList;
import java.util.List;

public class Rolls
{
  List<Integer> hitPins = new ArrayList<>();

  public void add(int pins)
  {
    hitPins.add(pins);
  }

  public int countHitPins()
  {
    return hitPins.stream().mapToInt(i -> i).sum();
  }
}
