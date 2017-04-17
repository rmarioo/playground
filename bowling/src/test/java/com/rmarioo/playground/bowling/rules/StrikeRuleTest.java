package com.rmarioo.playground.bowling.rules;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StrikeRuleTest
{

  @Test
  public void foundStrike() throws Exception
  {
    List<Integer> rolls = Arrays.asList(10,2,3);

    assertThat(new StrikeRule(rolls).score(0),is(2+3));
  }

  @Test
  public void notFoundStrike() throws Exception
  {
    List<Integer> rolls = Arrays.asList(7,2,3);
    assertThat(new StrikeRule(rolls).score(0),is(0));
  }

}