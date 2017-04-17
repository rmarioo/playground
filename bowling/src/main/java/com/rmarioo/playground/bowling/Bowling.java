package com.rmarioo.playground.bowling;

import com.rmarioo.playground.bowling.rules.BowlingRule;
import com.rmarioo.playground.bowling.rules.CompositeRule;
import com.rmarioo.playground.bowling.rules.PinsRule;
import com.rmarioo.playground.bowling.rules.SpareRule;
import com.rmarioo.playground.bowling.rules.StrikeRule;

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
                                    new SpareRule(rolls),
                                    new StrikeRule(rolls)));
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
