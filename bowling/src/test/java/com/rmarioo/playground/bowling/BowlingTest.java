package com.rmarioo.playground.bowling;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingTest
{

  @Test
  public void allZeroRolls() throws Exception
  {
    Bowling bowling = new Bowling();
    for (int i = 0; i < 20; i++)
      bowling.roll(0);

    assertThat(bowling.score(),is(0));
  }

  @Test
  public void notZeroRoll() throws Exception
  {
    Bowling bowling = new Bowling();
    bowling.roll(2);
    for (int i = 0; i < 19; i++)
      bowling.roll(0);

    assertThat(bowling.score(),is(2));
  }
}
