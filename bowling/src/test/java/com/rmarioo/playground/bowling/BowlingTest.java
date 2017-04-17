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
    rollManyZeros(20);
    assertThat(bowling.score(),is(0));
  }

  @Test
  public void aNotZeroRoll() throws Exception
  {
    bowling.roll(2);
    rollManyZeros(19);
    assertThat(bowling.score(),is(2));
  }

  @Test
  public void moreNotZeroRolls() throws Exception
  {
    bowling.roll(2);
    bowling.roll(3);
    rollManyZeros(18);
    assertThat(bowling.score(),is(5));
  }


  @Test
  public void aSpare() throws Exception
  {
    bowling.roll(2);
    bowling.roll(3);
    spare();
    bowling.roll(1);
    rollManyZeros(17);
    assertThat(bowling.score(),is(2+3+ 10+1+1));

  }

  @Test
  public void aStrike() throws Exception
  {
    bowling.roll(7);
    bowling.roll(1);
    strike();
    bowling.roll(2);
    bowling.roll(3);
    rollManyZeros(16);
    assertThat(bowling.score(),is( 7+1+ 10+2+3+2+3));

  }

  private void strike()
  {
    bowling.roll(10);
  }

  private void spare()
  {
    bowling.roll(2);
    bowling.roll(8);
  }

  private void rollManyZeros(int howMany)
  {
    for (int i = 0; i < howMany; i++)
    {
      bowling.roll(0);
    }
  }
}
