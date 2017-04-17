package com.rmarioo.playground.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class Bowling
{
  private List<Integer> rolls = new ArrayList();
  private final BowlingRule rule;

  public Bowling()
  {
    rule = new CompositeRule(asList(new PinsRule(rolls),
                                    new SpareRule(rolls)));
  }

  public void roll(int pins)
  {
    rolls.add(pins);
  }

  public int score()
  {
    return IntStream.range(0, rolls.size())
                    .map(i -> rule.score(i))
                    .sum();
  }

}
