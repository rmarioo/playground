package com.rmarioo.playground.bowling.rules;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PinsRuleTest
{
  @Test
  public void score() throws Exception
  {
    List<Integer> rolls = Arrays.asList(3,2,1,8);

    assertThat(new PinsRule(rolls).score(0),is(3));
  }


}