package com.rmarioo.playground.bowling.rules;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SpareRuleTest
{

  @Test
  public void foundSpare() throws Exception
  {
    List<Integer> rolls = Arrays.asList(2,8,3);

    assertThat(new SpareRule(rolls).score(0),is(3));
  }

  @Test
  public void notFoundSpare() throws Exception
  {
    List<Integer> rolls = Arrays.asList(2,7,3);

    assertThat(new SpareRule(rolls).score(0),is(0));
  }
}