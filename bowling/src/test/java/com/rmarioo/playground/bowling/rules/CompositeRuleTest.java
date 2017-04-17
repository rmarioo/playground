package com.rmarioo.playground.bowling.rules;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class CompositeRuleTest
{
  @Rule
  public JUnitRuleMockery mockery = new JUnitRuleMockery();

  private BowlingRule rule1 = mockery.mock(BowlingRule.class,"rule1");
  private BowlingRule rule2 = mockery.mock(BowlingRule.class,"rule2");

  private List<BowlingRule> rules = Arrays.asList(rule1,rule2);
  CompositeRule compositeRule = new CompositeRule(rules);

  @Test
  public void sumAllScores() throws Exception
  {
    mockery.checking(new Expectations() {{
      allowing(rule1).score(0); will(returnValue(8));
      allowing(rule2).score(0); will(returnValue(1));
    }});

    int score = compositeRule.score(0);

    Assert.assertThat(score,is(9));

  }
}