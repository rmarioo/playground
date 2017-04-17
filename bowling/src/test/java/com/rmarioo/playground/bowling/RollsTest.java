package com.rmarioo.playground.bowling;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RollsTest
{

  @Test
  public void sumOne() throws Exception
  {
   Rolls rolls = new Rolls();
   rolls.add(5);
   assertThat(rolls.countHitPins(),is(5));
  }

  @Test
  public void sumMoreThanOne() throws Exception
  {
   Rolls rolls = new Rolls();
   rolls.add(5);
   rolls.add(2);
   assertThat(rolls.countHitPins(),is(7));
  }
}
