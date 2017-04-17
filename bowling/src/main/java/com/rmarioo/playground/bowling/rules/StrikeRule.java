package com.rmarioo.playground.bowling.rules;

import java.util.List;

public class StrikeRule implements BowlingRule
{
  private final List<Integer> rolls;

  public StrikeRule(List<Integer> rolls)
  {
    this.rolls = rolls;
  }

  @Override
  public int score(int i)
  {
    return isStrike(i) ? strikeBonus(i) : 0;
  }

  private int strikeBonus(int i)
  {
    return rolls.get(i+1) + rolls.get(i+2);
  }

  private boolean isStrike(int i)
  {
    return i < rolls.size()-1 && rolls.get(i) == 10;
  }
}
