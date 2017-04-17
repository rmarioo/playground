package com.rmarioo.playground.bowling;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class StrikeRuleTest
{

  @Test
  public void computeStrike() throws Exception
  {
    List<Integer> pins = Arrays.asList(10, 2, 3, 0, 0,
      0, 0, 0, 0, 0,
      0, 0, 0, 0, 0,
      0, 0, 0, 0, 0);

    BowlingRule strikeRule = new StrikeRule(pins);

    Assert.assertThat(strikeRule.score(0),is(2+3));

  }

  @Test
  public void returnZeroIfNotStrike() throws Exception
  {
    List<Integer> pins = Arrays.asList(2, 2, 3, 0, 0,
      0, 0, 0, 0, 0,
      0, 0, 0, 0, 0,
      0, 0, 0, 0, 0);

    BowlingRule strikeRule = new StrikeRule(pins);

    Assert.assertThat(strikeRule.score(0),is(0));

  }
}
