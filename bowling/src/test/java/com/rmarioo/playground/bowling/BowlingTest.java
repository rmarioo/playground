package com.rmarioo.playground.bowling;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingTest
{

  private final Bowling bowling = new Bowling();

  @Test
  public void allZeroRolls() throws Exception
  {
    rollMany(0, 20);
    assertThat(bowling.score(),is(0));
  }

  @Test
  public void aNotZeroRoll() throws Exception
  {
    bowling.roll(2);
    rollMany(0, 19);
    assertThat(bowling.score(),is(2));
  }

  private void rollMany(int score, int howMany)
  {
    for (int i = 0; i < howMany; i++)
    {
      bowling.roll(score);
    }
  }
}
