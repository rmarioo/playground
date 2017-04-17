package com.rmarioo.playground.bowling;

import java.util.List;

class CompositeRule implements BowlingRule
{
  private List<BowlingRule> rules;

  public CompositeRule(List<BowlingRule> rules)
  {
    this.rules = rules;
  }

  public int score(int i)
  {
    return rules.stream().mapToInt(rule -> rule.score(i)).sum();
  }
}
