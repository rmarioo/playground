package com.rmarioo.playground.bowling.rules;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.nCopies;
import static org.hamcrest.CoreMatchers.is;

public class PinsRuleTest
{
  @Test
  public void score() throws Exception
  {
    List<Integer> rolls = new ArrayList<>(nCopies(20, 3));

    Assert.assertThat(new PinsRule(rolls).score(0),is(3));
  }


}